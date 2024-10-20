package com.frokanic.cryptopeek

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import com.frokanic.model.util.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class AllCryptoViewModel @Inject constructor(
    allCurrenciesUseCase: AllCurrenciesUseCase
) : ViewModel() {

    private val _searchQuery: MutableStateFlow<String?> = MutableStateFlow(null)
    val searchQuery: StateFlow<String?> = _searchQuery.asStateFlow()

    val allCurrenciesUiState: StateFlow<AllCurrenciesUiState> =
        allCurrenciesUseCase()
            .flatMapLatest { result ->
                flowOf(
                    when(result) {
                        is Result.Failure ->
                            AllCurrenciesUiState
                                .Failure(
                                    errorDescription = result.errorDescription
                                )

                        is Result.FailureWithFallback ->
                            AllCurrenciesUiState
                                .FailureWithFallback(
                                    currencies = result.data.currencies,
                                    errorDescription = result.errorDescription
                                )

                        Result.Loading ->
                            AllCurrenciesUiState.Loading

                        is Result.Success ->
                            AllCurrenciesUiState.Success(
                                currencies = result.data.currencies.orEmpty()
                            )
                    }
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = AllCurrenciesUiState.Loading
            )

    fun onSearchQueryUpdated(value: String?) {
        _searchQuery.value = value
    }

}
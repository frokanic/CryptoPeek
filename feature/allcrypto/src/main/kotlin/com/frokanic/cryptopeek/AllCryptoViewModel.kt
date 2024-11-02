package com.frokanic.cryptopeek

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCase
import com.frokanic.model.model.CurrencyOverview
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import com.frokanic.model.util.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AllCryptoViewModel @Inject constructor(
    allCurrenciesUseCase: AllCurrenciesUseCase
) : ViewModel() {

    private val _searchQuery: MutableStateFlow<String?> = MutableStateFlow(value = null)
    internal val searchQuery: StateFlow<String?> = _searchQuery.asStateFlow()

    private val allCurrenciesUiState: StateFlow<AllCurrenciesUiState> =
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
                                    currencies = result.data.currencies?.sortedByDescending { it.marketCap }.orEmpty(),
                                    errorDescription = result.errorDescription
                                )

                        Result.Loading ->
                            AllCurrenciesUiState.Loading

                        is Result.Success ->
                            AllCurrenciesUiState.Success(
                                currencies = result.data.currencies?.sortedByDescending { it.marketCap }.orEmpty()
                            )
                    }
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = AllCurrenciesUiState.Loading
            )

    internal val allCurrenciesQueried: StateFlow<AllCurrenciesUiState> =
        combine(
            allCurrenciesUiState,
            _searchQuery
        ) { allCurrencies, _ ->
            when (allCurrencies) {
                is AllCurrenciesUiState.Loading ->
                    AllCurrenciesUiState.Loading

                is AllCurrenciesUiState.Failure ->
                    AllCurrenciesUiState.Failure(
                        errorDescription = allCurrencies.errorDescription
                    )

                is AllCurrenciesUiState.FailureWithFallback ->
                    AllCurrenciesUiState.FailureWithFallback(
                        currencies = allCurrencies.currencies.queryAllCurrencies(),
                        errorDescription = allCurrencies.errorDescription
                    )

                is AllCurrenciesUiState.Success ->
                    AllCurrenciesUiState.Success(
                        currencies = allCurrencies.currencies.queryAllCurrencies()
                    )
            }
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = AllCurrenciesUiState.Loading
            )


    internal fun onSearchQueryUpdated(value: String?) {
        _searchQuery.value = value
    }

    private fun List<CurrencyOverview>.queryAllCurrencies() =
        this.filter { currency ->
            val containedInSymbol = currency.symbol.contains(_searchQuery.value.orEmpty(), ignoreCase = true)
            val containedInName = currency.name.contains(_searchQuery.value.orEmpty(), ignoreCase = true)

            containedInSymbol || containedInName
        }

}
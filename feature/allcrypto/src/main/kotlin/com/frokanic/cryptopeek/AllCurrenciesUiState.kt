package com.frokanic.cryptopeek

import com.frokanic.model.model.CurrencyOverview

sealed interface AllCurrenciesUiState {

    data object Loading : AllCurrenciesUiState

    data class Success(
        val currencies: List<CurrencyOverview>
    ) : AllCurrenciesUiState

    data class Failure(
        val errorDescription: String
    ) : AllCurrenciesUiState

    data class FailureWithFallback(
        val currencies: List<CurrencyOverview>,
        val errorDescription: String
    ) : AllCurrenciesUiState

}
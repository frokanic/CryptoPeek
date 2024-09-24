package com.frokanic.cryptopeek.usecase

import com.frokanic.cryptopeek.repository.AllCurrenciesRepository
import com.frokanic.model.model.AllCurrencies
import com.frokanic.model.util.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

interface AllCurrenciesUseCase {
    suspend fun invoke(): StateFlow<Result<AllCurrencies>>
}

class AllCurrenciesUseCaseImpl(
    private val repository: AllCurrenciesRepository
) : AllCurrenciesUseCase {

    override suspend fun invoke(): StateFlow<Result<AllCurrencies>> {
        repository.allCurrencies.collectLatest {
            if (it !is Result.Failure) {
                delay(10_000)
                repository.getAllCurrencies()
            }
        }
        return repository.allCurrencies
    }
}
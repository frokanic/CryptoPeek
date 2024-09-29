package com.frokanic.cryptopeek.usecase

import com.frokanic.cryptopeek.repository.AllCurrenciesRepository
import com.frokanic.model.model.AllCurrencies
import com.frokanic.model.util.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

interface AllCurrenciesUseCase {
    operator fun invoke(): StateFlow<Result<AllCurrencies>>
}

class AllCurrenciesUseCaseImpl(
    private val repository: AllCurrenciesRepository,
    private val scope: CoroutineScope
) : AllCurrenciesUseCase {

    override operator fun invoke(): StateFlow<Result<AllCurrencies>> {
        scope.launch(Dispatchers.IO) {
            repository.allCurrencies.collectLatest { result ->
                if (result !is Result.Failure) {
                    delay(10_000)
                    repository.getAllCurrencies()
                }
            }
        }
        return repository.allCurrencies
    }
}
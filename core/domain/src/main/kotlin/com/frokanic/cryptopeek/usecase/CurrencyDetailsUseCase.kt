package com.frokanic.cryptopeek.usecase

import com.frokanic.cryptopeek.repository.CurrencyDetailsRepository
import com.frokanic.model.model.CurrencyDetails
import com.frokanic.model.util.Result

interface CurrencyDetailsUseCase {
    suspend operator fun invoke(id: String): Result<CurrencyDetails>
}

class CurrencyDetailsUseCaseImpl(
    private val repository: CurrencyDetailsRepository
) : CurrencyDetailsUseCase {

    override suspend operator fun invoke(id: String): Result<CurrencyDetails> =
        repository.getCoinInfo(id = id)

}
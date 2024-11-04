package com.frokanic.cryptopeek.repository

import com.frokanic.cryptopeek.api.CryptoApi
import com.frokanic.cryptopeek.mapper.errorCodeToMessageMapper
import com.frokanic.cryptopeek.mapper.toCurrencyDetails
import com.frokanic.model.model.CurrencyDetails
import com.frokanic.model.util.Result

interface CurrencyDetailsRepository {
    suspend fun getCoinInfo(id: String): Result<CurrencyDetails>
}

class CurrencyDetailsRepositoryImpl(
    private val api: CryptoApi
) : CurrencyDetailsRepository {

    override suspend fun getCoinInfo(id: String): Result<CurrencyDetails> {
        val response = api.getCoinInfo(id = id)

        return if (response.isSuccessful) {
            if (response.body() == null) {
                Result.Failure(
                    errorCode = -1,
                    errorDescription = ""
                )
            } else {
                Result.Success(
                    data = response.body()!!.toCurrencyDetails()
                )
            }
        } else {
            Result.Failure(
                errorCode = response.code(),
                errorDescription = errorCodeToMessageMapper(code = response.code())
            )
        }
    }

}
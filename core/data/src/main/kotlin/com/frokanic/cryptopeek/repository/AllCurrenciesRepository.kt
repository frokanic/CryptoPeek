package com.frokanic.cryptopeek.repository

import com.frokanic.cryptopeek.api.CryptoApi
import com.frokanic.cryptopeek.mapper.toCurrencyOverview
import com.frokanic.model.model.AllCurrencies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.frokanic.model.util.Result
import retrofit2.HttpException

interface AllCurrenciesRepository {
    val allCurrencies: StateFlow<Result<AllCurrencies>>
    fun getAllCurrencies()
}

class AllCurrenciesRepositoryImpl(
    private val api: CryptoApi
) : AllCurrenciesRepository {

    private val _allCurrencies = MutableStateFlow<Result<AllCurrencies>>(Result.Loading)
    override val allCurrencies: StateFlow<Result<AllCurrencies>> = _allCurrencies.asStateFlow()

    override fun getAllCurrencies() {
        try {
            val result = api
                .getAllCrypto(
                    vsCurrency = "eur"
                )

            if (result.isSuccessful) {
                _allCurrencies.value = Result.Success(
                    data = AllCurrencies(
//                        timestamp = ,
                        currencies = result.body()?.map {
                            it.toCurrencyOverview()
                        }
                    )
                )
            } else {
                evaluateFailure(
                    code = result.code()
                )
            }
        } catch (e: HttpException) {
            evaluateFailure(
                code = e.code()
            )
        } catch (e: Exception) {
            evaluateFailure(
                code = CustomCodes.GENERIC_ERROR.code
            )
        }
    }

    private fun evaluateFailure(
        code: Int
    ) {
        val currentValue = _allCurrencies.value

        _allCurrencies.value = when(currentValue) {
            is Result.Success -> {
                Result.FailureWithFallback(
                    data = currentValue.data,
                    errorCode = code
                )
            }
            else -> {
                Result.Failure(
                    errorCode = code
                )
            }
        }
    }

    private enum class CustomCodes(
        val code: Int
    ) {
        GENERIC_ERROR(code = -1)
    }
}
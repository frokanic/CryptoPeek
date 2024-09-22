package com.frokanic.cryptopeek.api

import com.frokanic.cryptopeek.model.CurrencyResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoApi {

    // Todo: Take notes on @Query, @Path and @Body. Especially on @Body, since the other 2 are pretty straightforward.
    @GET("coins/markets")
    fun getAllCrypto(
        @Query("vs_currency") vsCurrency: String,
    ): Response<List<CurrencyResponseModel>>

    @GET("coins/{id}")
    fun getCoinInfo(
        @Path("id") id: String
    ): Response<CurrencyResponseModel>

}
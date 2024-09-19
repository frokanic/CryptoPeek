package com.frokanic.cryptopeek.repository

import com.frokanic.cryptopeek.api.CryptoApi

interface AllCurrenciesRepository {

}

class AllCurrenciesRepositoryImpl(
    private val api: CryptoApi
) : AllCurrenciesRepository {

}
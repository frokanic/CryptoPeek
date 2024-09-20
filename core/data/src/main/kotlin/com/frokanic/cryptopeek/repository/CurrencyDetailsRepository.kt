package com.frokanic.cryptopeek.repository

import com.frokanic.cryptopeek.api.CryptoApi

interface CurrencyDetailsRepository {

}

class CurrencyDetailsRepositoryImpl(
    private val api: CryptoApi
) : CurrencyDetailsRepository {

}
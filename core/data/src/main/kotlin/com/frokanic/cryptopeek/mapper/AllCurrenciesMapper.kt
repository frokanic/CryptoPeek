package com.frokanic.cryptopeek.mapper

import com.frokanic.cryptopeek.model.CurrencyResponseModel
import com.frokanic.model.model.CurrencyOverview

fun CurrencyResponseModel.toCurrencyOverview(): CurrencyOverview =
    CurrencyOverview(
        id = id,
        name = name,
        symbol = symbol,
        image = image,
        currentPrice = currentPrice,
        priceChangePercentage24H = priceChange24h,
        marketCap = marketCap
    )
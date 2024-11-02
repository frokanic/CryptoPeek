package com.frokanic.cryptopeek.mapper

import com.frokanic.cryptopeek.model.CurrencyResponseModel
import com.frokanic.model.model.CurrencyDetails

fun CurrencyResponseModel.toCoinInfo(): CurrencyDetails =
    CurrencyDetails(
        id = id,
        symbol = symbol,
        name = name,
        image = image,

        currentPrice = currentPrice,
        marketCap = marketCap,
        marketCapRank = marketCapRank,
        fullyDilutedValuation = fullyDilutedValuation,
        totalVolume = totalVolume,
        high24h = high24h,
        low24h = low24h,
        priceChange24h = priceChange24h,
        priceChangePercentage24h = priceChangePercentage24h,
        marketCapChange24h = marketCapChange24h,
        marketCapChangePercentage24h = marketCapChangePercentage24h,
        circulatingSupply = circulatingSupply,
        totalSupply = totalSupply,
        maxSupply = maxSupply,
        ath = ath,
        athChangePercentage = athChangePercentage,
        athDate = athDate,
        atl = atl,
        atlChangePercentage = atlChangePercentage,
        atlDate = atlDate,
        lastUpdated = lastUpdated
    )
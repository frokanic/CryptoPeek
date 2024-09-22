package com.frokanic.model.model

data class CurrencyOverview(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val image: String,
    val currentPrice: Double?,
    val priceChangePercentage24H: Double?
)

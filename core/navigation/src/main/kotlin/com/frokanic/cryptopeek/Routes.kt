package com.frokanic.cryptopeek

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object AllCrypto

    @Serializable
    data class CryptoDetails(val id: String)

}
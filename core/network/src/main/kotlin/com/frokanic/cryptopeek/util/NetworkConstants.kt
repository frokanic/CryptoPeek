package com.frokanic.cryptopeek.util

object NetworkConstants {

    /**
     *  Properties marked with the const modifier are compile-time constants, meaning
     *  their value is known at compile time, unlike val, where they can be assigned
     *  at run-time.
     *
     *  For that reason, they can only be of String or primitive type
     */
    // Todo: Research and take notes on how compile-time constants are better for performance.
    internal const val BASE_URL = "https://api.coingecko.com/api/v3/"
}
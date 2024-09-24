package com.frokanic.cryptopeek.mapper

internal fun errorCodeToMessageMapper(code: Int?): String =
    when(code) {
        // Redirection messages
        301 -> ""
        302 -> ""
        303 -> ""
        307 -> ""
        308 -> ""

        // Client error responses
        400 -> ""
        401 -> ""
        403 -> ""
        404 -> ""
        405 -> ""
        408 -> ""
        409 -> ""
        410 -> ""
        429 -> ""

        // Server error responses
        500 -> ""
        501 -> ""
        502 -> ""
        503 -> ""
        504 -> ""
        507 -> ""

        // Unknown errors
        else -> ""
    }
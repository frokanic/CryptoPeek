package com.frokanic.model.util

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data object Loading : Result<Nothing>()
    data class Failure(val errorCode: Int) : Result<Nothing>()
    data class FailureWithFallback<out T>(val data: T, val errorCode: Int) : Result<T>()
}
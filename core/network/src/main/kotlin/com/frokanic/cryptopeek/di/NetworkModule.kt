package com.frokanic.cryptopeek.di

import com.frokanic.cryptopeek.api.CryptoApi
import com.frokanic.cryptopeek.util.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Todo: Add notes on ohHttpClient, its logging ect.
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(
                interceptor = loggingInterceptor
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideCryptoApi(
        okHttpClient: OkHttpClient
    ): CryptoApi =
        Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(
                NetworkConstants.BASE_URL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

}
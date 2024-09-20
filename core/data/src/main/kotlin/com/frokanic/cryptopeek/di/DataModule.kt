package com.frokanic.cryptopeek.di

import com.frokanic.cryptopeek.api.CryptoApi
import com.frokanic.cryptopeek.repository.AllCurrenciesRepository
import com.frokanic.cryptopeek.repository.AllCurrenciesRepositoryImpl
import com.frokanic.cryptopeek.repository.CurrencyDetailsRepository
import com.frokanic.cryptopeek.repository.CurrencyDetailsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAllCurrenciesRepository(
        api: CryptoApi
    ): AllCurrenciesRepository =
        AllCurrenciesRepositoryImpl(
            api = api
        )

    @Provides
    fun provideCurrencyDetailsRepository(
        api: CryptoApi
    ): CurrencyDetailsRepository =
        CurrencyDetailsRepositoryImpl(
            api = api
        )
}
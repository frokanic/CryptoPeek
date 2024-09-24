package com.frokanic.cryptopeek.di

import com.frokanic.cryptopeek.repository.AllCurrenciesRepository
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCase
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideAllCurrenciesUseCase(
        repository: AllCurrenciesRepository
    ) : AllCurrenciesUseCase =
        AllCurrenciesUseCaseImpl(
            repository = repository
        )
}
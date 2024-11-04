package com.frokanic.cryptopeek.di

import com.frokanic.cryptopeek.repository.AllCurrenciesRepository
import com.frokanic.cryptopeek.repository.CurrencyDetailsRepository
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCase
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCaseImpl
import com.frokanic.cryptopeek.usecase.CurrencyDetailsUseCase
import com.frokanic.cryptopeek.usecase.CurrencyDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    // Todo Add this to the shared module, instead of here!
    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope =
        CoroutineScope(
            context = SupervisorJob() + Dispatchers.Default
        )

    @Provides
    fun provideAllCurrenciesUseCase(
        repository: AllCurrenciesRepository,
        scope: CoroutineScope
    ) : AllCurrenciesUseCase =
        AllCurrenciesUseCaseImpl(
            repository = repository,
            scope = scope
        )

    @Provides
    fun provideCurrencyDetailsUseCase(
        repository: CurrencyDetailsRepository
    ) : CurrencyDetailsUseCase =
        CurrencyDetailsUseCaseImpl(
            repository = repository
        )
}
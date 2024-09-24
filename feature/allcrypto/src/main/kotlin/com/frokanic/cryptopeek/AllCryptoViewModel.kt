package com.frokanic.cryptopeek

import androidx.lifecycle.ViewModel
import com.frokanic.cryptopeek.usecase.AllCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class AllCryptoViewModel @Inject constructor(
    private val allCurrenciesUseCase: AllCurrenciesUseCase
) : ViewModel() {

}
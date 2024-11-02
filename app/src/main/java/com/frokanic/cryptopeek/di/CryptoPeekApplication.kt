package com.frokanic.cryptopeek.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CryptoPeekApplication: Application()

//@HiltAndroidApp
//class CryptoPeekApplication: Application(), ImageLoaderFactory {
//
//    override fun newImageLoader(): ImageLoader =
//        TODO("Not yet implemented")
//
//}
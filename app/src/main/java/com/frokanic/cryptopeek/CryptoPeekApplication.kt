package com.frokanic.cryptopeek

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CryptoPeekApplication: Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader =
        TODO("Not yet implemented")

}
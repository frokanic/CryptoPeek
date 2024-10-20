package com.frokanic.cryptopeek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.frokanic.cryptopeek.navigation.CryptoPeekNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoPeekMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoPeekNavGraph()
        }
    }
}
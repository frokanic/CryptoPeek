package com.frokanic.cryptopeek.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frokanic.cryptopeek.AllCryptoScreen
import com.frokanic.cryptopeek.CryptoDetailsScreen
import com.frokanic.cryptopeek.Routes

@Composable
internal fun CryptoPeekNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.AllCrypto
    ) {
        composable<Routes.AllCrypto> {
            AllCryptoScreen(
                onClickOnItem = {
                    navController.navigate(
                        route = Routes.CryptoDetails(id = it)
                    )
                }
            )
        }

        composable<Routes.CryptoDetails> {
            CryptoDetailsScreen(
//                clickedCryptoId = it.id
            )
        }
    }
}
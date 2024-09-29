package com.frokanic.cryptopeek

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.frokanic.model.model.CurrencyOverview

@Composable
internal fun AllCryptoScreen(
    viewModel: AllCryptoViewModel = hiltViewModel()
) {
    val state: AllCurrenciesUiState by viewModel.allCurrenciesUiState.collectAsStateWithLifecycle()

    AllCryptoScreen(
        state = state
    )
}

@Composable
private fun AllCryptoScreen(
    modifier: Modifier = Modifier,
    state: AllCurrenciesUiState
) {

}

@Preview(showBackground = true)
@Composable
fun AllCryptoScreenPreview() {
    AllCryptoScreen(
        state = AllCurrenciesUiState
            .Success(
                currencies = listOf(
                    CurrencyOverview(
                        id = "bitcoin",
                        name = "Bitcoin",
                        symbol = "btc",
                        image = "https://coin-images.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
                        currentPrice = 58726.0,
                        priceChangePercentage24H = -0.20428,
                    ),
                    CurrencyOverview(
                        id = "ethereum",
                        name = "Ethereum",
                        symbol = "eth",
                        image = "https://coin-images.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
                        currentPrice = 2381.43,
                        priceChangePercentage24H = -0.08501
                    ),
                    CurrencyOverview(
                        id = "tether",
                        name = "Tether",
                        symbol = "usdt",
                        image = "https://coin-images.coingecko.com/coins/images/325/large/Tether.png?1696501661",
                        currentPrice = 0.895063,
                        priceChangePercentage24H = 0.01442
                    ),
                    CurrencyOverview(
                        id = "binancecoin",
                        name = "BNB",
                        symbol = "bnb",
                        image = "https://coin-images.coingecko.com/coins/images/825/large/bnb-icon2_2x.png?1696501970",
                        currentPrice = 537.1,
                        priceChangePercentage24H = -2.20945
                    ),
                    CurrencyOverview(
                        id = "solana",
                        name = "Solana",
                        symbol = "sol",
                        image = "https://coin-images.coingecko.com/coins/images/4128/large/solana.png?1718769756",
                        currentPrice = 140.34,
                        priceChangePercentage24H = -0.20695
                    )
                )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun AllCryptoScreenFailurePreview() {
    AllCryptoScreen(
        state = AllCurrenciesUiState.Failure(
            errorDescription = ""
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AllCryptoScreenLoadingPreview() {
    AllCryptoScreen(
        state = AllCurrenciesUiState.Loading
    )
}
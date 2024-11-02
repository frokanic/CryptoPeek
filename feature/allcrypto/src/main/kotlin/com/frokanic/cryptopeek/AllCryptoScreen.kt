package com.frokanic.cryptopeek

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.frokanic.cryptopeek.component.CryptoInfoItem
import com.frokanic.cryptopeek.component.CryptoPeekSearchBar
import com.frokanic.cryptopeek.component.PreviewCryptoInfoRowModel
import com.frokanic.model.model.CurrencyOverview

@Composable
fun AllCryptoScreen(
    viewModel: AllCryptoViewModel = hiltViewModel(),
    onClickOnItem: (String) -> Unit
) {
    val state: AllCurrenciesUiState by viewModel.allCurrenciesQueried.collectAsStateWithLifecycle()
    val searchQuery: String? by viewModel.searchQuery.collectAsStateWithLifecycle()

    AllCryptoScreen(
        state = state,
        searchQuery = searchQuery,
        onSearchQueryUpdated = { viewModel.onSearchQueryUpdated(it) },
        onClickOnItem = onClickOnItem
    )
}

@Composable
private fun AllCryptoScreen(
    modifier: Modifier = Modifier,
    state: AllCurrenciesUiState,
    searchQuery: String?,
    onSearchQueryUpdated: (String?) -> Unit,
    onClickOnItem: (String) -> Unit,

    isPreview: Boolean = false,
    previewImageId: Int? = null
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CryptoPeekSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    )
                    .padding(
                        top = (48 + 24).dp,
                        bottom = 16.dp
                    )
                ,
                searchText = searchQuery,
                onValueChange = { onSearchQueryUpdated(it) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    color = Color.Unspecified
                )
        ) {
            when(state) {
                AllCurrenciesUiState.Loading ->
                    LoadingBody()

                is AllCurrenciesUiState.Success ->
                    CoinsBody(
                        currencies = state.currencies,
                        onClickOnItem = onClickOnItem,
                        isPreview = isPreview,
                        previewImageId = previewImageId
                    )

                is AllCurrenciesUiState.FailureWithFallback ->
                    CoinsBody(
                        currencies = state.currencies,
                        onClickOnItem = onClickOnItem,
                        isPreview = isPreview,
                        previewImageId = previewImageId
                    )

                is AllCurrenciesUiState.Failure ->
                    ErrorBody()
            }
        }
    }
}

@Composable
private fun LoadingBody() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun CoinsBody(
    currencies: List<CurrencyOverview>,
    isPreview: Boolean = false,
    onClickOnItem: (String) -> Unit,
    previewImageId: Int? = null
) {
    LazyColumn(
        modifier = Modifier
            .padding(
                horizontal = 24.dp
            )
            .padding(
                top = 16.dp
            )
    ) {
        items(items = currencies) { item ->
            CryptoInfoItem(
                id = item.id,
                name = item.name,
                symbol = item.symbol.uppercase(),
                imageUrl = item.image,
                currentPrice = item.currentPrice,
                priceChangePercentage24H = item.priceChangePercentage24H,
                backgroundColor = Color.Unspecified,
                onClickOnItem = onClickOnItem,
                previewStatus = PreviewCryptoInfoRowModel(
                    isPreview = isPreview,
                    previewImageId = if (isPreview) previewImageId else null
                )
            )

            Spacer(
                modifier = Modifier
                    .height(
                        height = 16.dp
                    )
            )
        }
    }
}

@Composable
private fun ErrorBody() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "I AM AN ERROR PLACEHOLDER", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
private fun AllCryptoScreenPreview() {
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
                        marketCap = 1351353L
                    ),
                    CurrencyOverview(
                        id = "ethereum",
                        name = "Ethereum",
                        symbol = "eth",
                        image = "https://coin-images.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
                        currentPrice = 2381.43,
                        priceChangePercentage24H = -0.08501,
                        marketCap = 1351353L
                    ),
                    CurrencyOverview(
                        id = "tether",
                        name = "Tether",
                        symbol = "usdt",
                        image = "https://coin-images.coingecko.com/coins/images/325/large/Tether.png?1696501661",
                        currentPrice = 0.895063,
                        priceChangePercentage24H = 0.01442,
                        marketCap = 1351353L
                    ),
                    CurrencyOverview(
                        id = "binancecoin",
                        name = "BNB",
                        symbol = "bnb",
                        image = "https://coin-images.coingecko.com/coins/images/825/large/bnb-icon2_2x.png?1696501970",
                        currentPrice = 537.1,
                        priceChangePercentage24H = -2.20945,
                        marketCap = 1351353L
                     ),
                    CurrencyOverview(
                        id = "solana",
                        name = "Solana",
                        symbol = "sol",
                        image = "https://coin-images.coingecko.com/coins/images/4128/large/solana.png?1718769756",
                        currentPrice = 140.34,
                        priceChangePercentage24H = -0.20695,
                        marketCap = 1351353L
                    )
                )
            ),
        searchQuery = null,
        onSearchQueryUpdated = {  },
        onClickOnItem = {  },
        isPreview = true
    )
}

@Preview(showBackground = true)
@Composable
private fun AllCryptoScreenFailurePreview() {
    AllCryptoScreen(
        state = AllCurrenciesUiState.Failure(
            errorDescription = ""
        ),
        searchQuery = null,
        onSearchQueryUpdated = {  },
        onClickOnItem = {  },
    )
}

@Preview(showBackground = true)
@Composable
private fun AllCryptoScreenLoadingPreview() {
    AllCryptoScreen(
        state = AllCurrenciesUiState.Loading,
        searchQuery = null,
        onSearchQueryUpdated = {  },
        onClickOnItem = {  },
    )
}
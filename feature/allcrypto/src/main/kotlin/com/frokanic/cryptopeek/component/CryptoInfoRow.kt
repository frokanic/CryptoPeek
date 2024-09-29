package com.frokanic.cryptopeek.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.frokanic.cryptopeek.allcrypto.R

@Composable
fun CryptoInfoRow(
    modifier: Modifier = Modifier,
    name: String,
    symbol: String,
    imageUrl: String,
    currentPrice: Double,
    priceChangePercentage24H: Double,
    previewStatus: PreviewCryptoInfoRowModel = PreviewCryptoInfoRowModel()
) {
    val imageModifier = Modifier
        .height(24.dp)
        .width(24.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (previewStatus.isPreview) {
            Image(
                modifier = imageModifier,
                painter = painterResource(id = R.drawable.preview_btc),
                contentDescription = null
            )
        } else {
            AsyncImage(
                modifier = imageModifier,
                model = imageUrl,
                contentDescription = null
            )
        }

        Spacer(
            modifier = Modifier
                .width(8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = name
                )
                Text(
                    text = symbol
                )
            }
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = currentPrice.toString()
                )
                Text(
                    text = priceChangePercentage24H.toString()
                )
            }
        }
    }
}

data class PreviewCryptoInfoRowModel(
    val isPreview: Boolean = false,
    val previewImageId: Int? = null
)

@Preview(showBackground = true)
@Composable
fun CryptoInfoRowPreview() {
    CryptoInfoRow(
        name = "Bitcoin",
        symbol = "BTC",
        imageUrl = "https://coin-images.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
        currentPrice = 58984.0,
        priceChangePercentage24H = 1.38051,
        previewStatus = PreviewCryptoInfoRowModel(
            isPreview = true,
            previewImageId = R.drawable.preview_btc
        )
    )
}
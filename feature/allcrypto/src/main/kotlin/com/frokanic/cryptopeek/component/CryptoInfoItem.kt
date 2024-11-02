package com.frokanic.cryptopeek.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.frokanic.cryptopeek.allcrypto.R

@Composable
fun CryptoInfoItem(
    modifier: Modifier = Modifier,
    id: String,
    name: String,
    symbol: String,
    imageUrl: String,
    currentPrice: Double,
    priceChangePercentage24H: Double,
    backgroundColor: Color,
    onClickOnItem: (String) -> Unit,
    previewStatus: PreviewCryptoInfoRowModel = PreviewCryptoInfoRowModel()
) {
    val imageModifier = Modifier
        .height(36.dp)
        .width(36.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                color = backgroundColor
            )
            .clickable {
                onClickOnItem(id)
            }
        ,
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
                .fillMaxWidth()
                .padding(
                    start = 6.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = name,
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            height = 8.dp
                        )
                )

                Text(
                    text = symbol,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = currentPrice.toString(),
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            height = 8.dp
                        )
                )

                Text(
                    text = priceChangePercentage24H.toString(),
                    color = Color.Black
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
fun CryptoInfoItemPreview() {
    CryptoInfoItem(
        id = "1",
        name = "Bitcoin",
        symbol = "BTC",
        imageUrl = "https://coin-images.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
        currentPrice = 58984.0,
        priceChangePercentage24H = 1.380,
        backgroundColor = Color.Unspecified,
        onClickOnItem = {  },
        previewStatus = PreviewCryptoInfoRowModel(
            isPreview = true,
            previewImageId = R.drawable.preview_btc
        )
    )
}
package com.frokanic.cryptopeek

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun AllCryptoScreen(
    viewModel: AllCryptoViewModel = hiltViewModel()
) {

}

@Composable
private fun AllCryptoScreen(
    placeholder: String
) {

}

@Preview
@Composable
fun AllCryptoScreenPreview() {
    AllCryptoScreen("")
}
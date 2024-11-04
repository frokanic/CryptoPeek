package com.frokanic.cryptopeek

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CryptoDetailsScreen(
    viewModel: CryptoDetailsViewModel = hiltViewModel()
) {
    val currencyDetails = viewModel.currencyDetails.collectAsState()

//    LaunchedEffect(currencyDetails) {
//        Log.d("ARHG", currencyDetails.toString())
//    }
}

@Composable
private fun CryptoDetailsScreen(

) {

}

@Preview
@Composable
private fun CryptoDetailsScreenPreview() {

}

@Preview(showBackground = true)
@Composable
private fun CryptoDetailsScreenFailurePreview() {

}

@Preview(showBackground = true)
@Composable
private fun CryptoDetailsScreenLoadingPreview() {

}
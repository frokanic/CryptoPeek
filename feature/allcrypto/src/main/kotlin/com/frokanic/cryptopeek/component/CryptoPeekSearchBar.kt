package com.frokanic.cryptopeek.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CryptoPeekSearchBar(
    modifier: Modifier = Modifier,
    searchText: String? = null,
    onValueChange: (String?) -> Unit
) {
    Row(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    size = 16.dp
                )
            )
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = searchText.orEmpty(),
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"  // Todo: add it do my apps res/values/strings, with its greek version as well.
                )
            },
            trailingIcon = {
                if (!searchText.isNullOrEmpty()) {
                    Icon(
                        modifier = Modifier
                            .clickable {
                                onValueChange(null)
                            },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear search text icon"  // Todo: add it do my apps res/values/strings, with its greek version as well.
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Search..."
                )
            },
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Unspecified,
                unfocusedContainerColor = Color.Unspecified,
                focusedTextColor = Color.Unspecified,
                unfocusedTextColor = Color.Unspecified,
                focusedLeadingIconColor = Color.Unspecified,
                unfocusedLeadingIconColor = Color.Unspecified,
                focusedTrailingIconColor = Color.Unspecified
            )
        )
    }
}

@Composable
@Preview
fun CryptoPeekSearchBarPreview() {
    CryptoPeekSearchBar(
        searchText = "Bitc",
        onValueChange = {  }
    )
}

@Composable
@Preview
fun CryptoPeekSearchBarEmptyPreview() {
    CryptoPeekSearchBar(
        searchText = null,
        onValueChange = {  }
    )
}
package com.nameisjayant.articlesrepository.ui.paddings

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImePaddingDemo(
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier
            .imePadding()
    ) {
        item {
            Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
        }
        items(20) {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                label = { Text(text = "$it") }
            )
            if (it != 19)
                Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }

}
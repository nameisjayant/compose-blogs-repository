package com.nameisjayant.articlesrepository.ui.mvi

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun MVIScreen(
    modifier: Modifier = Modifier,
    viewModel: MVIViewModel = hiltViewModel()
) {

    val response by viewModel.fruitsState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(MVIEvent.ShowFruitsEvent)
    }

    Box(modifier = modifier.fillMaxSize()) {

        if (response.isLoading)
            CircularProgressIndicator(modifier = Modifier.padding(top = 30.dp).align(Alignment.TopCenter))

        if (response.error.isNotEmpty())
            Text(text = response.error, modifier = Modifier.align(Alignment.TopCenter))

        if (response.data.isNotEmpty())
            LazyColumn {
                items(response.data, key = { it }) {
                    Text(text = it, modifier = Modifier.padding(10.dp))
                }
            }

    }


}
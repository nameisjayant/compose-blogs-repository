package com.nameisjayant.articlesrepository.ui.paddings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.articlesrepository.R
import com.nameisjayant.articlesrepository.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaddingValueDemo() {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Purple80,
                modifier = Modifier.height(100.dp)
            ) {
                Text(text = stringResource(R.string.bottombar_app), color = Color.Black)
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_bar))
                }, colors = TopAppBarDefaults.smallTopAppBarColors(
                    titleContentColor = Color.Black,
                    containerColor = Purple80
                )
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            LazyColumn(

            ) {
                items(100) {
                    Text(text = "Text $it", modifier = Modifier.padding(vertical = 10.dp))
                }
            }
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    }

}
package com.nameisjayant.articlesrepository.ui.bottombar.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.nameisjayant.articlesrepository.R
import com.nameisjayant.articlesrepository.ui.bottombar.navigation.ScreenRoutes


@Composable
fun HomeScreen(
    navHostController: NavHostController,
    context: Activity
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            navHostController.navigate(ScreenRoutes.Detail.route)
        }) {
            Text(text = stringResource(R.string.move_to_detail_screen))
        }
    }

    BackHandler {
        context.finish()
    }

}
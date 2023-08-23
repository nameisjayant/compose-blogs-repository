package com.nameisjayant.articlesrepository.ui.bottombar.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nameisjayant.articlesrepository.ui.bottombar.navigation.BottomBarRoutes


@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Profile Screen", style = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp
        )
        )
    }

    BackHandler {
        navHostController.navigate(BottomBarRoutes.HOME.routes){
            popUpTo(BottomBarRoutes.HOME.routes){
                inclusive = true
            }
        }
    }

}
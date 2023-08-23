package com.nameisjayant.articlesrepository.ui.bottombar.navigation

import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nameisjayant.articlesrepository.R
import com.nameisjayant.articlesrepository.ui.bottombar.screens.DetailScreen
import com.nameisjayant.articlesrepository.ui.bottombar.screens.HomeScreen
import com.nameisjayant.articlesrepository.ui.bottombar.screens.NotificationScreen
import com.nameisjayant.articlesrepository.ui.bottombar.screens.ProfileScreen
import com.nameisjayant.articlesrepository.ui.bottombar.screens.SplashScreen


@Composable
fun BottomBarNavigation(
    navHostController: NavHostController,
    padding: PaddingValues,
    context:Activity
) {

    NavHost(
        navController = navHostController, startDestination = ScreenRoutes.Splash.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(ScreenRoutes.Splash.route) {
            SplashScreen(navHostController = navHostController)
        }
        navigation(
            route = ScreenRoutes.BottomBar.route,
            startDestination = BottomBarRoutes.HOME.routes
        ) {
            composable(BottomBarRoutes.HOME.routes) {
                HomeScreen(navHostController = navHostController,context)
            }
            composable(BottomBarRoutes.NOTIFICATION.routes) {
                NotificationScreen(navHostController = navHostController)
            }
            composable(BottomBarRoutes.Profile.routes) {
                ProfileScreen(navHostController = navHostController)
            }
        }
        composable(ScreenRoutes.Detail.route) {
            DetailScreen(navHostController = navHostController)
        }
    }

}

sealed class ScreenRoutes(val route: String) {

    data object Splash : ScreenRoutes("/splash")
    data object BottomBar : ScreenRoutes("/bottombar")
    data object Detail : ScreenRoutes("/detail")

}

enum class BottomBarRoutes(
    val id: Int,
    @StringRes val title: Int,
    val routes: String,
    @DrawableRes val icon: Int
) {

    HOME(1, R.string.home, "/home", R.drawable.home),
    NOTIFICATION(
        2,
        R.string.notification, "/notification", R.drawable.notification
    ),
    Profile(3, R.string.profile, "/profile", R.drawable.profile)

}
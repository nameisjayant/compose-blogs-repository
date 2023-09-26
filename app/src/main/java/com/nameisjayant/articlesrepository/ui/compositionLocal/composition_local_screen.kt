package com.nameisjayant.articlesrepository.ui.compositionLocal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.articlesrepository.R


@Composable
fun CompositionLocalScreen(
    modifier: Modifier
) {

    val context = LocalContext.current
    val ripple = LocalRippleTheme.current
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    val textStyle = LocalTextStyle.current

    //Text(text = stringResource(R.string.hello), style = textStyle)
   /* CompositionLocalProvider(
        LocalNavigation provides rememberNavController(),
        LocalCustomTextStyle provides ProvideCustomTextStyleData.customTextStyle,
    ) {
        PerformNavigation()
        ChildComposable()
    }*/
    CompositionLocalOf()

}

@Composable
fun CompositionLocalOf() {

    val textStyle = LocalTextStyleDemo.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.child_composable_function_using_composition_local),
            style = TextStyle(
                color = textStyle.color,
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight
            )
        )
    }

}


@Composable
fun PerformNavigation() {

    val navHostController = LocalNavigation.current
    NavHost(navController = navHostController, startDestination = "Screen") {
        composable("screen") {
            // your composable
        }
    }
}

val LocalTextStyleDemo = compositionLocalOf {
    CustomTextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.W500,
        color = Color.Blue
    )
}

val LocalNavigation = staticCompositionLocalOf<NavHostController> {
    error("No object of Navigation")
}

@Composable
fun ChildComposable() {
    val customTextStyle = LocalCustomTextStyle.current
    Text(
        text = stringResource(R.string.child_composable_function_using_composition_local),
        style = TextStyle(
            color = customTextStyle.color,
            fontSize = customTextStyle.fontSize,
            fontWeight = customTextStyle.fontWeight
        )
    )
}

@Stable
class CustomTextStyle(
    val fontSize: TextUnit,
    val fontWeight: FontWeight,
    val color: Color
)

val LocalCustomTextStyle = staticCompositionLocalOf<CustomTextStyle> {
    error("No Parameter is available")
}

object ProvideCustomTextStyleData {

    val customTextStyle = CustomTextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.W500,
        color = Color.Blue
    )

}
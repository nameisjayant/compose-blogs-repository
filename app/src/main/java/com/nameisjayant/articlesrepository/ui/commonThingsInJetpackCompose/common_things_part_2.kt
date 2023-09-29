package com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.nameisjayant.articlesrepository.R


@Composable
fun CustomFont(
    modifier: Modifier = Modifier
) {
    val customFont = FontFamily(
        Font(R.font.custom_font)
    )

    Text(text = stringResource(R.string.custom_font_text), fontFamily = customFont)

}

@Composable
fun AnimatedVisibilityScreen(
    modifier: Modifier = Modifier
) {

    var isShow by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = isShow) {
            Text(text = stringResource(R.string.animated_text))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            isShow = !isShow
        }) {
            Text(text = stringResource(R.string.show_hide))
        }
    }

}

@Composable
fun MakeCircle(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .background(
                    Color.Red,
                    CircleShape
                )
                .border(2.dp, Color.Black, CircleShape)
                .size(100.dp)
        )
    }

}
package com.nameisjayant.articlesrepository.ui.modifiers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.articlesrepository.R


@Composable
fun DrawBehindSomething(
    modifier: Modifier
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.hello_world),
            modifier = Modifier
                .drawBehind {
                    drawRoundRect(
                        color = Color.Black,
                        cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                    )
                }
                .padding(horizontal = 30.dp, vertical = 10.dp),
            color = Color.White
        )
    }

}

@Composable
fun DrawContentScreen(
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Spacer(modifier = Modifier
            .drawWithContent {
                drawRoundRect(
                    color = Color.Black,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
                drawCircle(
                    color = Color.Red
                )
            }
            .size(200.dp))
    }
}

@Composable
fun DrawWithCache(
    modifier: Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            "Hello Compose!",
            modifier = Modifier
                .drawWithCache {
                    val brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF9E82F0),
                            Color(0xFF42A5F5)
                        )
                    )
                    onDrawBehind {
                        drawRoundRect(
                            brush,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }
                }.padding(horizontal = 10.dp, vertical = 10.dp)
        )
    }
}
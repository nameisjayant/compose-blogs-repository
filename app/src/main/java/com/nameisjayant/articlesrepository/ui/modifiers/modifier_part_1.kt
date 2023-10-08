package com.nameisjayant.articlesrepository.ui.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MakeBorder(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Spacer(
            modifier = Modifier
                .border(
                    color = Color.Red,
                    width = 2.dp,
                    shape = CircleShape
                )
                .size(100.dp)
        )
    }
}

@Composable
fun ClipModifier(
    modifier: Modifier = Modifier
) {

    Spacer(modifier = modifier
        .padding(20.dp)
        .clip(CircleShape)
        .background(Color.Red)
        .size(100.dp))

}

@Composable
fun AlignModifier(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "Top Center", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "Center End", modifier = Modifier.align(Alignment.CenterEnd))
    }

}

@Composable
fun HorizontalScroll(
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .padding(20.dp)
            .horizontalScroll(scrollState)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(10) {
            Text(
                text = "Text $it",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }

}

@Composable
fun VerticalScroll(
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(20.dp)
            .verticalScroll(scrollState)
            .fillMaxSize(),
    ) {
        repeat(100) {
            Text(
                text = "Text $it",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }

}
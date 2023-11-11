package com.nameisjayant.articlesrepository.ui.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.articlesrepository.R


@Composable
fun WidthModifier(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(top = 20.dp)
            .background(Color.Red)
            .fillMaxWidth()
            //   .fillMaxWidth(0.5f)
            .height(50.dp)
    )

}

@Composable
fun WrapContentWidth(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .background(Color.Blue)
            // .fillMaxWidth()
            .wrapContentWidth(
                unbounded = true, align = Alignment.End
            )
            .widthIn()
    ) {
        Row(
            //  modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.hello_compose),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Composable
fun WidthInModifier(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .widthIn(
                min = 100.dp,
                max = 200.dp
            )
    ) {
        Text(text = stringResource(R.string.hello_world_how_are_you))
    }
}

@Composable
fun HeightModifier(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Red)
            .width(50.dp)
//            .fillMaxHeight(0.5f)
            .fillMaxHeight()
    )
}
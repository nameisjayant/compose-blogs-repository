package com.nameisjayant.articlesrepository.ui.modifiers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.articlesrepository.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarqueeText(
    modifier: Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(R.string.this_is_an_example_of_basic_marquee_text_in_jetpack_compose),
            fontSize = 20.sp,
            modifier = Modifier
                .basicMarquee()
                .testTag(stringResource(R.string.basicmarqueetest))
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CombinedClickableModifier(
    modifier: Modifier
) {
    Box(modifier = modifier.combinedClickable(onLongClick = {
        // perform long click operations
    }, onDoubleClick = {
        // perform double click operations
    }, onClick = {
        // click operations
    }))
}


@Composable
fun OffsetModifier(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(50.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(100.dp), contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = stringResource(R.string.offset_content),
            modifier = Modifier.offset(x = 0.dp, y = -(15.dp)),
            style = TextStyle(
                color = Color.Black, fontSize = 20.sp
            )
        )
    }
}
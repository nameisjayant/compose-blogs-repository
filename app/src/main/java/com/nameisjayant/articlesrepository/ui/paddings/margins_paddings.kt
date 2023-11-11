package com.nameisjayant.articlesrepository.ui.paddings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.articlesrepository.R


@Composable
fun MarginDemo(
    modifier: Modifier = Modifier
) {
    Button(onClick = {}, modifier = modifier.padding(20.dp)) {
        Text(text = stringResource(R.string.margin_demo))
    }
}

@Composable
fun PaddingDemo(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Button(onClick = {}, modifier = Modifier.padding(20.dp)) {
            Text(text = stringResource(R.string.margin_demo))
        }
    }
}

@Composable
fun PaddingFromDemo(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.background(Color.Red)) {
        Text(
            text = stringResource(R.string.padding_from_example),
            modifier = Modifier.paddingFrom(
                alignmentLine = FirstBaseline,
                before = 20.dp,
                // after = 20.dp
            )
        )
    }
}

@Composable
fun PaddingFromBaseLineExample(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Black)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.padding_from_baseline_example),
                modifier = Modifier
                    .background(Color.Red)
                    .paddingFromBaseline(
                        top = 30.dp
                    )
                    .weight(1f),
                color = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.norma_padding),
                modifier = Modifier.padding(top = 30.dp),
                color = Color.White
            )
        }
    }

}
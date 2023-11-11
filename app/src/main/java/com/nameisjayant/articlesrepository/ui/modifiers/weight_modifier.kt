package com.nameisjayant.articlesrepository.ui.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.articlesrepository.R


@Composable
fun WeightModifierDemo(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.weight_property), modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .background(Color.Red, CircleShape)
                .size(50.dp)
        )
    }

}

@Composable
fun WeightModifierDemo2(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .weight(0.5f)
                .height(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .weight(0.5f)
                .height(50.dp)
        )
    }

}

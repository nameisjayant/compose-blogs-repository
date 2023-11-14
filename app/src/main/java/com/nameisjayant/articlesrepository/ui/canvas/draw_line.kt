package com.nameisjayant.articlesrepository.ui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HutWithCanvasLine(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(260.dp)
        ) {
            val width = size.width
            val height = size.height

            // hut top part
            drawLine(
                color = Color.Red,
                start = Offset(x = width / 4, y = 0f),
                end = Offset(0f, y = height / 3),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Red,
                start = Offset(x = width / 4, y = 0f),
                end = Offset(width / 2, y = height / 3),
                strokeWidth = 5f
            )

            drawLine(
                color = Color.Red,
                start = Offset(x = 0f, y = height / 3),
                end = Offset(width / 2, y = height / 3),
                strokeWidth = 5f
            )

            // door outer part
            drawLine(
                color = Color.Blue,
                strokeWidth = 5f,
                start = Offset(x = 0f, y = height / 3),
                end = Offset(x = 0f, y = height)
            )
            drawLine(
                color = Color.Blue,
                strokeWidth = 5f,
                start = Offset(x = width / 2, y = height / 3),
                end = Offset(x = width / 2, y = height)
            )
            drawLine(
                color = Color.Blue,
                strokeWidth = 5f,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width / 2, y = height)
            )

            // Door
            drawLine(
                color = Color.Black,
                strokeWidth = 5f,
                start = Offset(x = (width / 2) / 3, y = height),
                end = Offset(x = (width / 2) / 3, y = height / 2)
            )
            drawLine(
                color = Color.Black,
                strokeWidth = 5f,
                start = Offset(x = (width / 2) / 1.5f, y = height),
                end = Offset(x = (width / 2) / 1.5f, y = height / 2)
            )
            drawLine(
                color = Color.Black,
                strokeWidth = 5f,
                start = Offset(x = (width / 2) / 3, y = height / 2),
                end = Offset(x = (width / 2) / 1.5f, y = height / 2)
            )

            // hut top side part
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width / 4, y = 0f),
                end = Offset(x = width, y = 0f)
            )
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width / 2, y = height / 3),
                end = Offset(x = width - 100, y = (height / 3))
            )
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width, y = 0f),
                end = Offset(x = width - 100, y = height / 3)
            )
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width, y = 0f),
                end = Offset(x = width, y = height)
            )
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width - 100, y = height / 3),
                end = Offset(x = width - 100, y = height)
            )
            drawLine(
                color = Color.Magenta,
                strokeWidth = 5f,
                start = Offset(x = width / 2, y = height),
                end = Offset(x = width, y = height)
            )

        }
    }
}


@Composable
fun DrawDiagonalLine(
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue
        )
    }

}

@Composable
fun DrawCenterToCenterLine(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth / 2, y = 0f),
            end = Offset(x = canvasWidth / 2, y = canvasHeight),
            color = Color.Blue,
            strokeWidth = 5.dp.toPx()
        )
    }
}

@Composable
fun DrawMultipleLines(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = 0.dp.toPx(), y = canvasHeight / 2),
            end = Offset(x = canvasWidth, y = canvasHeight / 2),
            color = Color.Blue,
            strokeWidth = 5.dp.toPx()
        )
        drawLine(
            start = Offset(x = canvasWidth / 2, y = 0f),
            end = Offset(x = canvasWidth / 2, y = canvasHeight),
            color = Color.Blue,
            strokeWidth = 5.dp.toPx()
        )
    }
}

@Composable
fun DrawDiagonallyRight(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = 0.dp.toPx(), y = 0f),
            end = Offset(x = canvasWidth, y = canvasHeight),
            color = Color.Blue,
            strokeWidth = 5.dp.toPx()
        )
    }
}

@Composable
fun DrawLineVerticallyCenter(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = 0.dp.toPx(), y = canvasHeight / 2),
            end = Offset(x = canvasWidth, y = canvasHeight / 2),
            color = Color.Blue,
            strokeWidth = 5.dp.toPx()
        )
    }
}
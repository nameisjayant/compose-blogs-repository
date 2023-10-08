package com.nameisjayant.articlesrepository.ui.longpress

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.articlesrepository.R


@Composable
fun SelectItems() {

    var isEnabled by remember { mutableStateOf(false) }
    var selectedItems by remember { mutableStateOf<Set<Int>>(emptySet()) }
    var selectAll by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = selectAll) {
        selectedItems = if (selectAll)
            selectedItems.plus(0..10)
        else
            selectedItems.minus(0..10)
    }

    Column {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .toggleable(
                    value = selectAll,
                    onValueChange = {
                        selectAll = it
                        isEnabled = it
                    },
                    role = Role.Checkbox
                )
        ) {
            Text(text = stringResource(R.string.selectall), modifier = Modifier.weight(1f))
            Checkbox(checked = selectAll, onCheckedChange = null)
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(10) { index ->
                EachRow(
                    isEnabled = isEnabled,
                    title = "Item $index",
                    selectedItem = selectedItems.contains(index),
                    onClick = {
                        selectedItems =
                            if (selectedItems.contains(index)) selectedItems.minus(index)
                            else selectedItems.plus(index)
                    },
                    onEnableChange = { value ->
                        isEnabled = value
                    },
                )
            }
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EachRow(
    modifier: Modifier = Modifier,
    title: String,
    isEnabled: Boolean,
    selectedItem: Boolean,
    onClick: () -> Unit,
    onEnableChange: (Boolean) -> Unit
) {

    Box(
        modifier = modifier
            .padding(15.dp)
            .background(Color.LightGray, RoundedCornerShape(4.dp))
            .size(80.dp)
            .combinedClickable(onLongClick = {
                onEnableChange(true)
            }, onClick = onClick)
    ) {
        if (isEnabled)
            Checkbox(
                checked = selectedItem, onCheckedChange = null, modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.TopEnd)
            )
        Text(
            text = title, style = TextStyle(
                color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.W700
            ), modifier = Modifier.align(Alignment.Center)
        )
    }

}
package com.nameisjayant.articlesrepository.ui.lazyColumnMultiHeader

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun LazyColumnWithMultiHeaderScreen(
    modifier: Modifier
) {

    // a mutable map variable , which indicate that item is visible or not
    var isShow = remember {
        mutableStateMapOf<String, Boolean>()
    }

    // by default we will store true , all the item will be visible
    LaunchedEffect(key1 = Unit) {
        isShow = isShow.apply {
            itemList.associate { item ->
                item.type to true
            }.also {
                putAll(it)
            }
        }
    }

    LazyColumn(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        val groupItems = itemList.groupBy { it.type }
        groupItems.forEach { (type, items) ->
            item {
                Row(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .fillMaxWidth()
                        .toggleable(
                            value = isShow[type] == true,
                            onValueChange = {
                                isShow[type] = it
                            },
                            role = Role.Button
                        )
                ) {
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = type,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                color = Color.Black,
                                fontWeight = FontWeight.W700
                            ),

                            )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "(${items.size})",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                color = Color.Black,
                            ),

                            )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        if (isShow[type] == true) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = null,
                        modifier = Modifier.align(CenterVertically)
                    )
                }
            }
            if (isShow[type] == true)
                items(items, key = { it.id }) {
                    Text(
                        text = it.name, style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.DarkGray
                        ),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
        }
    }

}

data class Item(
    val id: Int,
    val name: String,
    val type: String
)

val itemList = listOf(
    Item(
        1, "Tiger", "Animal"
    ),
    Item(
        2, "Lion", "Animal"
    ),
    Item(
        3, "Deer", "Animal"
    ),
    Item(
        4, "Lotus", "Flower"
    ),
    Item(
        5, "Sunflower", "Flower"
    ),
    Item(
        6, "Rose", "Flower"
    ),
    Item(
        7, "Table", "Furniture"
    ),
    Item(
        8, "Chair", "Furniture"
    ),
    Item(
        9, "Bed", "Furniture"
    ),
    Item(
        10, "Monkey", "Animal"
    ),
)

package com.nameisjayant.articlesrepository.ui.lazyColumnMultiHeader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.nameisjayant.articlesrepository.ui.theme.ArticlesRepositoryTheme

@OptIn(ExperimentalMaterial3Api::class)
class MultipleHeaderActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesRepositoryTheme {
                Scaffold { innerPadding ->
                    LazyColumnWithMultiHeaderScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
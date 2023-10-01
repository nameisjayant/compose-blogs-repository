package com.nameisjayant.articlesrepository.ui.lazyColumnMultiHeader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose.AnimatedVisibilityScreen
import com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose.MakeCircle
import com.nameisjayant.articlesrepository.ui.fonts.CustomFontScreen
import com.nameisjayant.articlesrepository.ui.mvi.MVIScreen
import com.nameisjayant.articlesrepository.ui.theme.ArticlesRepositoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MultipleHeaderActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesRepositoryTheme {
                Scaffold { innerPadding ->
                    MVIScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
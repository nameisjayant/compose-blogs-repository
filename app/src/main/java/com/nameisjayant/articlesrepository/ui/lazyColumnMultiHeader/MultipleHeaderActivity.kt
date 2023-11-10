package com.nameisjayant.articlesrepository.ui.lazyColumnMultiHeader

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsStartWidth
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose.AnimatedVisibilityScreen
import com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose.MakeCircle
import com.nameisjayant.articlesrepository.ui.fonts.CustomFontScreen
import com.nameisjayant.articlesrepository.ui.modifiers.AlignModifier
import com.nameisjayant.articlesrepository.ui.modifiers.ClipModifier
import com.nameisjayant.articlesrepository.ui.modifiers.HorizontalScroll
import com.nameisjayant.articlesrepository.ui.modifiers.MakeBorder
import com.nameisjayant.articlesrepository.ui.modifiers.MarqueeText
import com.nameisjayant.articlesrepository.ui.modifiers.OffsetModifier
import com.nameisjayant.articlesrepository.ui.modifiers.VerticalScroll
import com.nameisjayant.articlesrepository.ui.mvi.MVIScreen
import com.nameisjayant.articlesrepository.ui.paddings.ImePaddingDemo
import com.nameisjayant.articlesrepository.ui.paging3.domain.ui.DogsScreen
import com.nameisjayant.articlesrepository.ui.theme.ArticlesRepositoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MultipleHeaderActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ArticlesRepositoryTheme {
                Scaffold {
                  ImePaddingDemo()
                }
            }
        }
    }
}
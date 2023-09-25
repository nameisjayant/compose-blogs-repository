package com.nameisjayant.articlesrepository.ui.compositionLocal

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager


@Composable
fun CompositionLocalScreen() {

   val context = LocalContext.current
   val ripple = LocalRippleTheme.current
   val focusManager = LocalFocusManager.current
   val focusRequester = remember {FocusRequester()}

   CompositionLocalProvider(
      LocalContext provides context,
   ) {

   }


}
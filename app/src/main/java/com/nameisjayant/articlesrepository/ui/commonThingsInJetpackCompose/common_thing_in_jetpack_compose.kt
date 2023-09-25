package com.nameisjayant.articlesrepository.ui.commonThingsInJetpackCompose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import com.nameisjayant.articlesrepository.R


@Composable
fun FindContext() {

    val context = LocalContext.current

    Toast.makeText(context, "Hey", Toast.LENGTH_LONG).show()

}

@Composable
fun GetStringResource(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.get_text_from_string_resource))
    }

}

@Composable
fun CopyTextFromClipBoard(
    modifier: Modifier = Modifier
) {
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            clipboardManager.setText(AnnotatedString(context.getString(R.string.copy_text_from_clipboard)))
        }) {
            Text(text = stringResource(R.string.copy_text))
        }
    }

}

@Composable
fun StopRippleEffect(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.click_here),
            modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) { })
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FocusOnTextField(
    modifier: Modifier = Modifier
) {

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter username") },
            modifier = Modifier.focusRequester(focusRequester)
        )
    }

}

@Composable
fun ClickableTextScreen(
    modifier: Modifier = Modifier
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ClickableText(text = AnnotatedString(stringResource(R.string.clickable_text)), onClick = {
            // perform click here
        })
    }

}
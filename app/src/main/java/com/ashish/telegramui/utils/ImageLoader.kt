package com.ashish.telegramui.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun LoadingNetworkImage(url: String) {

    val painter = rememberCoilPainter(
        request = url
    )
    Image(painter = painter, contentDescription = "" , contentScale = ContentScale.Fit)
}

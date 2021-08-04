package com.ashish.telegramui.ui

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashish.telegramui.ui.theme.TelegramUiTheme
import com.ashish.telegramui.ui.theme.appbarColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


const val TAG = "FAV"
@Composable
fun HomeScreen() {

    var favClicked by remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()
    val angle : Float by animateFloatAsState(
        targetValue = if(favClicked) 120F else 0F ,
        animationSpec = tween(
            durationMillis = 1000 ,
            easing = FastOutLinearInEasing) ,
        finishedListener = {
            Log.d(TAG, "Fab: animation is finish ")

        }
    )

    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = appbarColor,
                contentColor = MaterialTheme.colors.onBackground,
                title = { Text("Telegram") },
                navigationIcon = {
                    IconButton(onClick = { },
                        modifier = Modifier.padding(16.dp)) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                },
                actions = {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }


            )
        },

        drawerGesturesEnabled = true,
        drawerContent = {
            DrawerHeader()

        },

        content = { ChatScreen() } ,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        favClicked = true
                        delay(5000)
                        favClicked = !favClicked
                    }

                    Log.d(TAG, "Fab is clicked $favClicked ")
                          } ,
            ) {
                Icon( modifier =  Modifier.rotate(angle) , imageVector = Icons.Default.Create,contentDescription = null)

            }
        }
    )

}


@Composable
@Preview()
fun HomePreview() {

    TelegramUiTheme {
        HomeScreen()
    }
}

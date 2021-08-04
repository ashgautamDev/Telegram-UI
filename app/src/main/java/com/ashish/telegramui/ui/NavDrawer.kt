package com.ashish.telegramui.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.telegramui.ui.theme.TelegramUiTheme


@Composable
fun NavigationItems(extendItems: Boolean = false) {
    var expandedState by remember { mutableStateOf(extendItems) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .animateContentSize { initialValue, targetValue -> },
        verticalArrangement = Arrangement.spacedBy(16.dp))
    {
        if (expandedState) {
            Item(title = "Add Account", icon = Icons.Default.Add)
            Divider(modifier = Modifier.fillMaxWidth())
        }
        Item(title = "New Group", icon = Icons.Default.Person)
        Item(title = "Contacts", icon = Icons.Default.Phone)
        Item(title = "Calls", icon = Icons.Default.Call)
        Item(title = "Info", icon = Icons.Default.Info)
        Item(title = "Settings", icon = Icons.Default.Settings)
        Divider(modifier = Modifier.fillMaxWidth())
        Item(title = "Invite Friends", icon = Icons.Default.Person)
        Item(title = "Telegram FAQ", icon = Icons.Default.AccountCircle)

    }
}

@Composable
fun Item(title: String, icon: ImageVector) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)) {
        Icon(imageVector = icon,
            contentDescription = null, tint = Color.Gray)
        Text(text = title, style = MaterialTheme.typography.subtitle1.copy(color = Color.White))
    }
}

@Composable
fun DrawerHeader() {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    Column(Modifier.fillMaxWidth()) {


        Card(
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier
                .clickable { expandedState = !expandedState }
                .fillMaxWidth()

        ) {

            Column(verticalArrangement = Arrangement.Top) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(color = MaterialTheme.colors.background),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(color = Color.Blue, shape = CircleShape),
                        contentAlignment = Alignment.Center,

                        ) {
                        Text(text = "AG",
                            style = MaterialTheme.typography.h5.copy(color = Color.White))
                    }


                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp))

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(color = MaterialTheme.colors.background),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    Column {
                        Text(text = "Ash Gautam", style = TextStyle(
                            fontSize = 16.sp
                        ).copy(color = Color.White))
                        Text(text = "+91 7864654654",
                            style = TextStyle(
                                fontSize = 14.sp
                            ).copy(color = Color.White))
                    }

                    Icon(imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { expandedState = !expandedState }
                            .rotate(rotationState),
                        tint = Color.White)

                }
            }

        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp))
        {
            if (expandedState) {
                Item(title = "Add Account", icon = Icons.Default.Add)
                Divider(modifier = Modifier.fillMaxWidth())
            }
            Item(title = "New Group", icon = Icons.Default.Person)
            Item(title = "Contacts", icon = Icons.Default.Phone)
            Item(title = "Calls", icon = Icons.Default.Call)
            Item(title = "Info", icon = Icons.Default.Info)
            Item(title = "Settings", icon = Icons.Default.Settings)
            Divider(modifier = Modifier.fillMaxWidth())
            Item(title = "Invite Friends", icon = Icons.Default.Person)
            Item(title = "Telegram FAQ", icon = Icons.Default.AccountCircle)

        }


    }
}


@Preview
@Composable
fun NavDrawerPreview() {
    TelegramUiTheme() {
        DrawerHeader()
    }


}
//
//@Preview
//@Composable
//fun NavItemsPreview() {
//    TelegramUiTheme {
//        NavigationItems()
//    }
//
//
//}

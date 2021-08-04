package com.ashish.telegramui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.telegramui.R
import com.ashish.telegramui.ui.theme.TelegramUiTheme
import com.ashish.telegramui.utils.LoadingNetworkImage


@Composable
fun ChatCard(
    name: String,
    lastMessage: String,
    dp: String,
    isMute: Boolean,
    pendingMessageInt: String,
    lastUpdate: String,
) {

    Card(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            // Icon or Dp 
            Box(modifier = Modifier
                .background(color = Color.White, shape = CircleShape)
                .size(40.dp)
            ,
                contentAlignment = Alignment.Center
            ) {
                LoadingNetworkImage(url = dp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Row(modifier = Modifier.fillMaxWidth().padding(end = 8.dp) ,
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = name, style = TextStyle(
                            fontSize = 20.sp
                        ),
                            color = Color.White)
                        if (isMute) {
                            Icon(painter =
                            painterResource(id = R.drawable.ic_baseline_volume_mute_24),
                                contentDescription = null , Modifier.size(16.dp) , tint = Color.Gray)
                        }
                    }
                    Text(
                        text = lastUpdate,
                        style = TextStyle(fontSize = 14.sp , letterSpacing = 0.5.sp),
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }
                Row(modifier = Modifier.fillMaxWidth().padding(end = 8.dp) ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(text = lastMessage, style = TextStyle(
                        fontSize = 16.sp,

                    ),
                        color = Color.Gray ,
                    overflow = TextOverflow.Ellipsis)

                    if (pendingMessageInt != "0") {
                    Box(
                        modifier = Modifier
                            .background(color = Color.Gray ,
                                shape = RoundedCornerShape(50) ),
                        contentAlignment = Alignment.Center) {
                        Text(text = pendingMessageInt.toString(),
                            style =TextStyle(
                                fontSize = 16.sp
                            ),
                            color = Color.White,
                            modifier = Modifier.padding(1.dp)
                        )
                    }} else {null}

                }

            }

        }
    }

}

@Preview
@Composable
fun ChatPreview() {
    TelegramUiTheme() {
        ChatCard(name = "Satoshi Space ",
            lastMessage = "ApEx Dot shor 38",
            dp = "https://static.toiimg.com/thumb/msid-69902898,imgsize-115506,width-800,height-600,resizemode-75/69902898.jpg",
            isMute = true,
            pendingMessageInt = "4",
            lastUpdate = " sat")
    }

}
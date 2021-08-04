package com.ashish.telegramui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashish.telegramui.component.ChatCard
import com.ashish.telegramui.data.fakedata.chatsList


@Composable
fun ChatScreen() {
    LazyColumn(){
        items(chatsList){
            ChatCard(name = it.name,
                lastMessage = it.lastMessage,
                dp = it.image,
                isMute = it.onMute,
                pendingMessageInt = it.unreadMessage,
                lastUpdate = it.lastUpdate)
        }

    }
}

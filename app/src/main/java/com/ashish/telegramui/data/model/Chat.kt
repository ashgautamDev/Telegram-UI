package com.ashish.telegramui.data.model

data class Chat(

    val name :String ,
    val image : String ,
    val lastMessage : String,
    val lastUpdate : String ,
    val unreadMessage : String = "0",
    val onMute : Boolean = false ,
)

package com.ashish.telegramui.data

data class Model(

    val name :String ,
    val image : String ,
    val lastMessage : String,
    val lastUpdate : String ,
    val unreadMessage : Int = 0,
    val onMute : Boolean = false ,
)

package com.geektech.playlistrv

import java.io.Serializable

data class Song(
    val name: String,
    val artist: String,
    val duration: String,
    val image: String
): Serializable

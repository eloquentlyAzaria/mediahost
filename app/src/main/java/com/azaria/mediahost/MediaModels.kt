package com.azaria.mediahost

data class SubsonicResponse(
    val `subsonic-response`: SubsonicContent
)

data class SubsonicContent(
    val status: String,
    val albumList: AlbumList?
)

data class AlbumList(
    val album: List<Album>
)

data class Album(
    val id: String,
    val title: String,
    val artist: String,
    val coverArt: String?
)
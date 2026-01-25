package com.azaria.mediahost

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NavidromeApi {
    @GET("rest/getAlbumList.view")
    suspend fun getAlbums(
        @QueryMap auth: Map<String, String>,
        @retrofit2.http.Query("type") type: String = "newest"
    ): SubsonicResponse
}
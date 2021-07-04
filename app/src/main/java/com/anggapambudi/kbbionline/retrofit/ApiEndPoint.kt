package com.anggapambudi.kbbionline.retrofit

import com.anggapambudi.kbbionline.model.KamusResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoint {

    @GET("search?")
    fun getData(
        @Query("q") kata: String
    ): Call<KamusResponse>

}
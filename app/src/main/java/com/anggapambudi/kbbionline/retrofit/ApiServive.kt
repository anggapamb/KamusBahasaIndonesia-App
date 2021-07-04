package com.anggapambudi.kbbionline.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServive {

    private const val BASE_URL = "https://kbbi-api-amm.herokuapp.com/"

    val instance: ApiEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiEndPoint::class.java)
    }

}
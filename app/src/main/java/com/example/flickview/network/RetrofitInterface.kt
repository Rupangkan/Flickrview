package com.example.flickview.network

import com.example.flickview.data.Flickr
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface RetrofitInterface {
//    @FormUrlEncoded
//    @Headers("Accept: application/json")
    @GET
    suspend fun loadSpecialUsers(@Url url: String): Response<Flickr>
}
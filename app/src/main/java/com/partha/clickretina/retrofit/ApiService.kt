package com.partha.clickretina.retrofit

import com.partha.clickretina.pojoClasses.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("b/6HBE")
    fun getResponse(): Call<Response>
}

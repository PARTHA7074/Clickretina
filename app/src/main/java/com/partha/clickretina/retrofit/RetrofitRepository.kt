package com.partha.clickretina.retrofit

import com.partha.clickretina.pojoClasses.Response
import retrofit2.Call

object RetrofitRepository {
    private val apiService = RetrofitClient.apiService

    fun getResponse(): Call<Response> {
        return apiService.getResponse()
    }

}
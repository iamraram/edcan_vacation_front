package com.haram.edcan_vacation

import retrofit2.Call
import retrofit2.http.*

data class ResponseDC(var result:String? = null)

interface APIInterface {
    @GET("/community")
    fun getRequest(@Query("name") name: String): Call<ResponseDC>
}
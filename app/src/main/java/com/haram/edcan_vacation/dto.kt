package com.haram.edcan_vacation

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class MessageInfo(
    @SerializedName("num") val num: Int,
    @SerializedName("message") val message: String,
    @SerializedName("userId") val userId: Int,
    @SerializedName("isHeart") val isHeart: Boolean,
    @SerializedName("date") val date: Int
) {
/*    override fun toString(): String {
        return "messageResult: [\n" +
                "    Num: ${num}\n" +
                "    message: ${message}\n" +
                "    userId: ${userId}\n" +
                "    isHeart: ${isHeart}\n" +
                "    date: ${date}\n" +
                "]"
    }*/
}

interface ApiService {
    @GET("/message")
    fun info(): Call<MessageInfo>

}

object RetrofitObject {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}

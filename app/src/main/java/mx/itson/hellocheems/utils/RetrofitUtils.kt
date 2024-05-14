package mx.itson.hellocheems.utils

import com.google.gson.GsonBuilder
import mx.itson.hellocheems.interfaces.HelloCheems
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    fun getApi() : HelloCheems? {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder().baseUrl("http://127.0.0.1:8000/v1/").addConverterFactory(GsonConverterFactory.create(gson)).build()
        return retrofit.create(HelloCheems::class.java)
    }
}
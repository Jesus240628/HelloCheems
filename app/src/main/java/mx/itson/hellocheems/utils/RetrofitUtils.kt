package mx.itson.hellocheems.utils

import com.google.gson.GsonBuilder
import mx.itson.hellocheems.interfaces.Cheemsito
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    fun getApi() : Cheemsito? {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder().baseUrl("http://127.0.0.1:8000/v1/Post").addConverterFactory(GsonConverterFactory.create(gson)).build()
        return retrofit.create(Cheemsito::class.java)
    }
}
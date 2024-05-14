package mx.itson.hellocheems.interfaces

import mx.itson.hellocheems.entities.Visit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Cheemsito {
    @GET("visit")
    fun getvisits(@Query("name") name: String,
                  @Query("reason") reason: String,
                  @Query("responsible") responsible: String,
                  @Query("latitude") latitude: String,
                  @Query("longitude") longitude: String) : Call<List<Visit>>

}
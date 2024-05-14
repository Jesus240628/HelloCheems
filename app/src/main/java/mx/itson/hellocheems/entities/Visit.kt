package mx.itson.hellocheems.entities

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.hellocheems.persistence.CheemsDB

class Visit {
    var id = 0
    var name : String? = null
    var reason : String? = null
    var responsible : String? = null
    var latitude : Float? = null
    var longitude : Float? = null
    constructor()

    constructor(id: Int,name: String,reason: String,responsible: String, latitude : Float, longitude : Float){
        this.id = id
        this.name = name
        this.reason = reason
        this.responsible = responsible
        this.latitude = latitude
        this.longitude = longitude

}
fun get(context: Context) : List<Visit>{
    val contacts:MutableList<Visit> = ArrayList()
    try {
        val cheemsDB = CheemsDB (context, "CheemsDB", null, 1)
        val database: SQLiteDatabase = cheemsDB.writableDatabase

        val cursor = database.rawQuery("SELECT id, name, reason, responsible, latitude, longitude FROM Location",null)
        while (cursor.moveToNext()){
            val contact = Visit(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getFloat(4),
                cursor.getFloat(5))
            contacts.add(contact)
        }
    }catch (ex: Exception) {
        Log.e("Error to get contacts", ex.message.toString())
    }
    return contacts
    }
}
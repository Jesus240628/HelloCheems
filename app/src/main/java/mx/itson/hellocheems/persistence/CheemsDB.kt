package mx.itson.hellocheems.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class CheemsDB (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(sqlDatabase: SQLiteDatabase) {
            try {
                sqlDatabase.execSQL("CREATE TABLE Location (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT, Reason TEXT, Responsible TEXT, Latutide FLOAT, LONGITUDE FLOAT)")
            }catch (ex: Exception){
                Log.e("Error al crear la base de datos", ex.message.toString())
            }
    }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
}
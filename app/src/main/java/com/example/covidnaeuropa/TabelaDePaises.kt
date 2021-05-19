package com.example.covidnaeuropa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaDePaises(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db
    fun cria(){
        db.execSQL("CREATE TABLE paises(_id INTEGER PRIMARY KEY AUTOINCREMENTE, nome TEXT NOT NULL)")

    }


    companion object{
        const val NOME_TABELA = "paises"

    }


}

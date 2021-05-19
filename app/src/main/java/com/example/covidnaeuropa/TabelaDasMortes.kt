package com.example.covidnaeuropa

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class TabelaDasMortes(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria(){
        db.execSQL("CREATE TABLE ")
    }

    fun insert(values: ContentValues):Long{
        return db.insert(NOME_TABELA, null, values)
    }

    fun update(values: ContentValues)

    companion object{
        const val NOME_TABELA = "mortes"


    }
}

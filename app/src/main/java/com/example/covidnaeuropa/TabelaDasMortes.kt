package com.example.covidnaeuropa

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaDasMortes(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NUMERO_MORTES + " INTEGER, " +
                CAMPO_MEDIA + " INTEGER, " +
                CAMPO_ID_PAIS + " INTEGER NOT NULL, " +
                "FOREIGN KEY(" + CAMPO_ID_PAIS + ") " +
                "REFERENCES " + TabelaDePaises.NOME_TABELA +
                ")")
    }

    companion object{
        const val NOME_TABELA = "mortes"
        const val NUMERO_MORTES = "numero"
        const val CAMPO_MEDIA = "media"
        const val CAMPO_ID_PAIS = "id_pais"
    }
}

package com.example.covidnaeuropa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaNovasInfecoes (db: SQLiteDatabase){
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOVAS + " INTEGER NOT NULL, " +
                CAMPO_MEDIA + " INTEGER NOT NULL, " +
                CAMPO_ID_PAIS + " INTEGER NOT NULL, " +
                "FOREIGN KEY(" + CAMPO_ID_PAIS + ") " +
                "REFERENCE " + TabelaDePaises.NOME_TABELA +
                ")")

    }


    companion object{
        const val NOME_TABELA = "infecoes"
        const val CAMPO_NOVAS = "novas"
        const val CAMPO_MEDIA = "media"
        const val CAMPO_ID_PAIS = "id_pais"

    }
}
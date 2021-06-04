package com.example.covidnaeuropa

import android.content.ContentValues

class País(var id: Long = -1, var nome: String, var continente: String, var idInfeccoes: Long, var idMortes: Long) {
    fun toContenteValues(): ContentValues{
        val valores = ContentValues().apply {
            put(TabelaDePaises.CAMPO_NOME, nome)
            put(TabelaDePaises)
        }
    }
}
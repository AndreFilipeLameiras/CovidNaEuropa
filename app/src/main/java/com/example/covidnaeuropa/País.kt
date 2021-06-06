package com.example.covidnaeuropa

import android.content.ContentValues

data class País(var id: Long = -1, var nome: String, var continente: String, var idInfeccoes: Long, var idMortes: Long) {
    fun toContenteValues(): ContentValues{
        val valores = ContentValues().apply {
            put(TabelaDePaises.CAMPO_NOME, nome)
            put(TabelaDePaises.CAMPO_CONTINENTE, continente)
            put(TabelaDePaises.CAMPO_ID_INFECOES, idInfeccoes)
            put(TabelaDePaises.CAMPO_ID_MORTES, idMortes)
        }

        return valores
    }



}
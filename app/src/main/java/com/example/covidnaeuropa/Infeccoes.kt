package com.example.covidnaeuropa

import android.content.ContentValues

data class Infeccoes(var id: Long = -1, var numero: Int, var idPais: Long) {
    fun toContentValues(): ContentValues{
        val valores = ContentValues().apply {
            put(TabelaNovasInfecoes.CAMPO_NOVAS, numero)
            put(TabelaNovasInfecoes.CAMPO_ID_PAIS, idPais)
        }

        return valores
    }
}
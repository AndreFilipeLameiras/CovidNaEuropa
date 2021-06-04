package com.example.covidnaeuropa

import android.content.ContentValues

data class Infeccoes(var id: Long = -1, var numero: Int) {
    fun toContentValues(): ContentValues{
        val valores = ContentValues()
        valores.put(TabelaNovasInfecoes.CAMPO_NOVAS, numero)
        return valores
    }
}
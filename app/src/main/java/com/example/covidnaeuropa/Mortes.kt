package com.example.covidnaeuropa

import android.content.ContentValues

data class Mortes(var id: Long = -1, var numero: Int) {
    fun toContentValues(): ContentValues{
        val valores = ContentValues()
        valores.put(TabelaDasMortes.NUMERO_MORTES, numero)
        return valores
    }
}
package com.example.covidnaeuropa

import android.content.ContentValues

data class Mortes(var id: Long = -1, var numero: Int, var idPais: Long) {
    fun toContentValues(): ContentValues{
        val valores = ContentValues().apply {
            put(TabelaDasMortes.NUMERO_MORTES, numero)
            put(TabelaDasMortes.CAMPO_ID_PAIS, idPais)
        }

        return valores
    }
}
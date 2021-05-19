package com.example.covidnaeuropa

import android.content.ContentValues
import android.database.Cursor
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

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaDePaises.NOME_TABELA, null, values)
    }


    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaDePaises.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaDePaises.NOME_TABELA, whereClause, whereArgs)
    }


    fun query(
            columns: Array<String>,
            selection: String,
            selectionArgs: Array<String>,
            groupBy: String,
            having: String,
            orderBy: String): Cursor? {
        return db.query(TabelaDePaises.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object{
        const val NOME_TABELA = "mortes"
        const val NUMERO_MORTES = "numero"
        const val CAMPO_MEDIA = "media"
        const val CAMPO_ID_PAIS = "id_pais"
    }
}

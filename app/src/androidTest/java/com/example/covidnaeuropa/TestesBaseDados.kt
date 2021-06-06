package com.example.covidnaeuropa

import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestesBaseDados {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext
    private fun getbdCovid19Europa() = BdCovid19Europa(getAppContext())


    private fun insereNovasInfeccoes(tabela: TabelaNovasInfecoes,infeccoes: Infeccoes): Long {
        val id = tabela.insert(infeccoes.toContentValues())
        assertEquals(-1, id)
        return id
    }



    @Before
    fun apagaBaseDados(){
        getAppContext().deleteDatabase(BdCovid19Europa.NOME_BASE_DADOS)
    }

    @Test
    fun consegueAbrirBaseDados(){
        val openHelper = BdCovid19Europa(getAppContext())
        val  db = openHelper.readableDatabase
        assert(db.isOpen)
        db.close()
    }

    @Test
    fun consegueInserirNovasInfeccoes(){
        val db = getbdCovid19Europa().writableDatabase
        val tabelaNovaInfecoes = TabelaNovasInfecoes(db)

        val infeccoes = Infeccoes(numero = 12, idPais = 4)
        infeccoes.id = insereNovasInfeccoes(tabelaNovaInfecoes, infeccoes)

        db.close()

    }

    @Test
    fun consegueAlterarNovasInfeccoes(){
        val db = getbdCovid19Europa().writableDatabase
        val tabelaNovaInfecoes = TabelaNovasInfecoes(db)

        val infeccoes = Infeccoes(numero = 14, idPais = 8)
        infeccoes.id = insereNovasInfeccoes(tabelaNovaInfecoes, infeccoes)

        infeccoes.numero = 16
        infeccoes.idPais = 13

        val registosAlterados = tabelaNovaInfecoes.update(
                infeccoes.toContentValues(),
                "${BaseColumns._ID}=?",
                arrayOf(infeccoes.id.toString())
        )

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueEliminarNovasInfeccoes(){
        val db = getbdCovid19Europa().writableDatabase
        val tabelaNovaInfecoes = TabelaNovasInfecoes(db)

        val infeccoes = Infeccoes(numero = 11, idPais = 7)
        infeccoes.id = insereNovasInfeccoes(tabelaNovaInfecoes, infeccoes)

        val registosEliminados = tabelaNovaInfecoes.delete(
                "${BaseColumns._ID}=?",
                arrayOf(infeccoes.id.toString())
        )

        assertEquals(1, registosEliminados)

        db.close()
    }
}
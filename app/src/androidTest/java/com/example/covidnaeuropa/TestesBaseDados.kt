package com.example.covidnaeuropa

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

        val id = tabelaNovaInfecoes.insert()
    }

}
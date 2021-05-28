package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
    mainViewModel.buscarContaCliente().observe(this, Observer {
            result -> bindOnView(result)
    })
    }

    private fun bindOnView(conta : Conta) {
    findViewById<TextView>(R.id.tvAg).text = conta.agencia
    findViewById<TextView>(R.id.tvAccount).text = conta.numero
    findViewById<TextView>(R.id.tvSaldoValue).text = conta.saldo
    findViewById<TextView>(R.id.tvSaldoLimiteValue).text = conta.limite
    findViewById<TextView>(R.id.tvUser).text = conta.cliente.nome
    findViewById<TextView>(R.id.ivCardNumber).text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
        //sempre seja exibido
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("Click","Click item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}
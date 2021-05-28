package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData() : Conta {
        val cliente = Cliente("Roberta")
        val cartao = Cartao("4896254869855641")
        return Conta(
            "Cc 123456",
            "Ag 0078",
            "R$ 5.298,45",
            "R$ 10.000,00",
            cliente,
            cartao
        );
    }

}
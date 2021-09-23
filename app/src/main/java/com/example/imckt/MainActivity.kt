package com.example.imckt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.imckt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnCalcular.setOnClickListener{
            val valorPeso = bind.numPeso.text.toString().toDouble()
            val valorAltura = bind.numAltura.text.toString().toDouble()
            val calculoImc = CalculoImc(valorPeso, valorAltura)
            Toast.makeText(this,calculoImc.calcular(), Toast.LENGTH_LONG).show()//52:32 da aula

        }


    }
}
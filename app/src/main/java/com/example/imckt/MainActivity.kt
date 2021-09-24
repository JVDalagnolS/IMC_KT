package com.example.imckt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton

import com.example.imckt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnCalcular.setOnClickListener{
            val valorPeso = bind.numPeso.text.toString().toDouble()
            val valorAltura = bind.numAltura.text.toString().toDouble()
            val escolhaSexo = escolhaRB
            val calculoImc = CalculoImc(valorPeso, valorAltura, escolhaSexo)

            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("IMC",calculoImc)
            startActivity(intent)
        }
    }

    var escolhaRB: Int = 0

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioMasculino ->
                    if (checked) {
                        escolhaRB = 1
                    }
                R.id.radioFeminino ->
                    if (checked) {
                        escolhaRB = 2
                    }
            }
        }
    }
}
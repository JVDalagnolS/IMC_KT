package com.example.imckt


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imckt.databinding.ActivityMain2Binding
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bind.root)

        val calc = intent.getParcelableExtra<CalculoImc>("IMC")

        bind.lblPeso.text = calc?.peso.toString()
        bind.lblAltura.text = calc?.altura.toString()
        bind.lblGrauPeso.text = calc?.grauImc(applicationContext)
        bind.lblResultIMC.text = calc?.calculo().toString()
        bind.lblSexo.text = calc?.escolhaSexo(applicationContext).toString()
    }
}
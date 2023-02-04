package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/* declarando variaveis e ligando ao xml*/
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        /*dando função a um botão*/
        btnCalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()
/*se os capos de altura e peso estiverem preenchidos, execute*/
            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura

                val peso: Float = pesoStr.toFloat()
                val result: Float = peso / alturaFinal

                /*esse codigo intent explicita avisa ao android que será feito um movimento de saida dessa
            * tela para a tela result*/
                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }else{/*se não estiver preenchido, mostre a mensagem*/
                Toast.makeText(this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_LONG).show()
            }
        }
    }
}
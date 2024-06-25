package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edttxt_peso)
        val edtAltura: EditText = findViewById(R.id.edttxt_altura)


        btnCalcular.setOnClickListener{



            val alturaSTR = edtAltura.text.toString()
            val pesoSTR = edtPeso.text.toString()

            if(alturaSTR.isNotEmpty() && pesoSTR.isNotEmpty()){

            val altura: Float = alturaSTR.toFloat()
            val peso: Float = pesoSTR.toFloat()

            val alturaFinal: Float = altura * altura
            val result : Float = peso/alturaFinal


           val intent = Intent(this, ResultActivity::class.java)
               .apply {
                   putExtra("EXTRA_RESULT", result)
               }

            startActivity(intent)
            }else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }

    }
}
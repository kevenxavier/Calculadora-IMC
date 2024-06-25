package com.example.meuprimeiroprojeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificação = findViewById<TextView>(R.id.textview_classificacao)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text= result.toString()


        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f){
            "PESO IDEAL"
        }else if (result in 25f..29.9f){
            "SOBREPESO"
        }else if (result in 30f..39.9f){
            "OBESIDADE"
        }else {
            "OBESIDADE MÓRBIDA"
        }

        tvClassificação.text= getString(R.string.message_classificacao,classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }

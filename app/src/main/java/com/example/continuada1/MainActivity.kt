package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clicaNiMin(componete:View) {


        if (text_nome.text.toString().isEmpty()){
            text_final.setTextColor(Color.BLUE)
            text_final.text = "Por favor preencher o campo -> Nome"
        }
        if (text_salario.text.toString().isEmpty()){
            text_final.setTextColor(Color.GREEN)
            text_final.text = "Por favor preencher o campo -> Salário"
        }
        if (text_tempo.text.toString().isEmpty()){
            text_final.setTextColor(Color.RED)
            text_final.text = "Por favor preencher o campo -> Período"
        }

        if(!text_tempo.toString().isEmpty() && !text_salario.toString().isEmpty() && !text_nome.toString().isEmpty())
        {

            val nome:String = text_nome.text.toString()

            val pagamento:Double = text_salario.text.toString().toDouble()

            val fraseSalario = when (pagamento) {
                in Double.MIN_VALUE..-1.0 -> "Salário Inválido"
                0.0 -> "Está disponível para o mercado de Trabalho! Talvez Seja voluntário ou é muito novo para trabalhar"
                in 1.0..1044.99 -> " Você Possui Salário Abaixo do Mínimo"
                in 3000.00..Double.MAX_VALUE -> "Você Possui um Salário Acima da Média"
                else -> "Você possui um Salário na Média"
            }

            val tempo:Int = text_tempo.text.toString().toInt()

            fun calcSalario(): Double {
                return  pagamento* tempo
            }

            text_final.setTextColor(Color.YELLOW)
            text_final.text = "Oi ${nome}, você terá R$${calcSalario()} reais no período de ${tempo} mês(s)! ${fraseSalario}"
        }
    }

}
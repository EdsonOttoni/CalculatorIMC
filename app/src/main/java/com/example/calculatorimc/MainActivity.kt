package com.example.calculatorimc

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        seekBarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                text_height.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        seekBarWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                text_weight.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button.setOnClickListener {
            calculate(text_weight.text.toString(), text_height.text.toString())
        }

    }

    private fun calculate(weight: String, height: String){
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()

        if(weight != null && height != null){
            val imc = (weight / (height * height)) * 10000
            imc_text.text = "Seu IMC"
            imc_text.textSize = 30F
            result_imc.text = imc.toString()
            result_imc.textSize = 48F
            result_imc_description.textSize = 28F

            when {
                imc < 18.5 -> {
                    result_imc_description.text = "De pouco peso"
                    result_imc_description.setTextColor(Color.RED)
                }
                imc in 18.5..24.9 -> {
                    result_imc_description.text = "normal"
                    result_imc_description.setTextColor(Color.GREEN)
                }
                imc in 25.0..29.9 -> {
                    result_imc_description.text = "Excesso de peso"
                    result_imc_description.setTextColor(Color.YELLOW)
                }
                else -> {
                    result_imc_description.text = "Obeso"
                    result_imc_description.setTextColor(Color.RED)
                }
            }
        }

    }

}



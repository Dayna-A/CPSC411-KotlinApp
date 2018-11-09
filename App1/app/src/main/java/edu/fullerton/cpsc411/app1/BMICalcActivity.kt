package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bmicalc.*

class BMICalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalc)

        val calcButton = calcButton as Button
        val printResult = BMITextView as TextView

        calcButton.setOnClickListener {
            printResult.text = calcBMI();
        }
    }

    fun calcBMI(): String {
        val heightIn = hEditText.text.toString().toDouble()
        val height = heightIn * 0.0254
        val weightLb = wEditText.text.toString().toDouble()
        val weight = weightLb / 2.205

        val bmi = weight / (height * height)

        return java.lang.Integer.toString(bmi.toInt())
    }
}
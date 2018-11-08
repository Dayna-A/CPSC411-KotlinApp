package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_binary_calc.*

class CelsiusFarenheitCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_calc)

        val tvBinaryNum = binaryNumEditText as EditText

        tvBinaryNum.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //error checking for nullptr exception and empty case
                if (s != null && !s.toString().equals("", ignoreCase = true)) {
                    updateCalculation(tvBinaryNum)
                }
            }
        })
    }

    fun updateCalculation(tvBinaryNum: EditText) {

        if(tvBinaryNum.text.length > 0) {
            var binaryNum = Integer.parseInt(tvBinaryNum.text.toString())
            var i = 0
            var decimalNum = 0

            val printResult = newNumberTextView as TextView

            while(binaryNum != 0) {
                val remainder = binaryNum % 10
                binaryNum /= 10
                decimalNum += (remainder * Math.pow(2.0, i.toDouble())).toInt()
                i++
            }
            printResult.text = java.lang.Integer.toString(decimalNum)
        }
    }

}

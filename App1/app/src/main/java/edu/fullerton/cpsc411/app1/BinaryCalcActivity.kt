package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_binary_calc.*

class BinaryCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_calc)

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
            var binaryNum = tvBinaryNum.text.toString()

            var j = 0
            var decimalNum = 0.0

            val printResult = newNumberTextView as TextView

            for(i in binaryNum.length-1 downTo 0) {
                //for(i in 0..binaryNum.length-1) {
                decimalNum += (binaryNum.get(i).toString().toDouble() * Math.pow(2.0, j.toDouble()))
                println(binaryNum.get(j))
                println(binaryNum.get(j).toString().toDouble())
                println(Math.pow(2.0, j.toDouble()))
                j++
            }
            printResult.text = java.lang.Integer.toString(decimalNum.toInt())
        }
    }

}

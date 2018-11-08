package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_temperature_calc.*

class CelsiusFahrenheitCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_calc)

        val tvFahrenheitNum = fahrenheit_io as EditText
        val tvCelsiusNum = celsius_io as EditText

        tvFahrenheitNum.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //error checking for nullptr exception and empty case
                if (s != null && !s.toString().equals("", ignoreCase = true)) {
                    updateCelsius(tvFahrenheitNum)
                }
            }
        })

        tvCelsiusNum.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //error checking for nullptr exception and empty case
                if (s != null && !s.toString().equals("", ignoreCase = true)) {
                    updateFahrenheit(tvCelsiusNum)
                }
            }
        })
    }

    fun updateCelsius(tvFahrenheitNum: EditText) {

        if(tvFahrenheitNum.editableText.isNotEmpty()) {

            var fahrenheitVal = Integer.parseInt(tvFahrenheitNum.text.toString())
            var celsiusVal = (fahrenheitVal-32)*(5.0/9.0)

            celsius_io.setText("")
            result_o.text= DecimalFormat("#.0#").format(celsiusVal)+"° C"
        }
    }

    fun updateFahrenheit(tvCelsiusNum: EditText) {

        if(tvCelsiusNum.editableText.isNotEmpty()) {

            var celsiusVal = Integer.parseInt(tvCelsiusNum.text.toString())
            var fahrenheitVal = (celsiusVal*(9.0/5.0))+32

            fahrenheit_io.setText("")
            result_o.text=DecimalFormat("#.0#").format(fahrenheitVal)+"° F"
        }
    }

}

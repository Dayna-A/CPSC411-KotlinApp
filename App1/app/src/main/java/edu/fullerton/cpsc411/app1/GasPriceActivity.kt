package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_gasprice.*
import kotlinx.android.synthetic.main.activity_temperature_calc.*

class GasPriceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_calc)

        //val tvPricePerGallon = pricePerGallon_i as EditText
        val tvPricePerGallon = findViewById<EditText>(R.id.pricePerGallon_i)
        val tvCurrencyPerUSD = findViewById<EditText>(R.id.currencyPerUSD_i)

        tvPricePerGallon!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //error checking for nullptr exception and empty case
                if (s != null && !s.toString().equals("", ignoreCase = true)) {
                    updateUPL(tvPricePerGallon)
                }
            }
        })

        tvCurrencyPerUSD!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //error checking for nullptr exception and empty case
                if (s != null && !s.toString().equals("", ignoreCase = true)) {
                    updateFPL(tvCurrencyPerUSD)
                }
            }
        })
    }

    fun updateUPL(tvPricePerGallon: EditText) {

        if(tvPricePerGallon.editableText.isNotEmpty()) {

            var pricePerUSGallon = Integer.parseInt(tvPricePerGallon.text.toString())
            var usdPerLiter = pricePerUSGallon/3.78541

            usd_perLitre_val.text= "$ "+ (DecimalFormat("#.0#").format(usdPerLiter))
        }
    }

    fun updateFPL(tvCurrencyPerUSD: EditText) {

        if(pricePerGallon_i.editableText.isNotEmpty()&& currencyPerUSD_i.editableText.isNotEmpty()) {

            var pricePerUSGallon = Integer.parseInt(pricePerGallon_i.text.toString())
            var foreignCurrencyPerUSD = Integer.parseInt(tvCurrencyPerUSD.text.toString())
            var foreignCurPerLiter = (pricePerUSGallon/3.78541)*foreignCurrencyPerUSD

            yourCurrency.text= DecimalFormat("#.0#").format(foreignCurPerLiter)
        }
    }

}

package edu.fullerton.cpsc411.app1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import android.text.TextWatcher
import edu.fullerton.cpsc411.app1.R.id.*
import kotlinx.android.synthetic.main.activity_gasprice.*


class GasPriceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gasprice)

        val tvPricePerGallon = pricePerGallon_i as EditText
        val tvCurrencyPerUSD = currencyPerUSD_i as EditText

        tvPricePerGallon!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                updateUPL(tvPricePerGallon)
            }
        })

        tvCurrencyPerUSD!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                updateFPL(tvCurrencyPerUSD)
            }
        })
    }

    fun updateUPL(tvPricePerGallon: EditText) {
        try{
            if(pricePerGallon_i.editableText.isNotEmpty()) {
                var pricePerUSGallon = (tvPricePerGallon.text.toString()).toDouble()

                var usdPerLiter = pricePerUSGallon/3.78541

                usd_perLitre_val.text= "$ "+ (DecimalFormat("#.0##").format(usdPerLiter))
            }else{
                usd_perLitre_val.text="0.00"
                yourCurrency.text="0.00"
            }
        }catch (inputEventSender: Exception) {

        }catch (MessageQueue: Exception){

        }catch(AndroidRuntime: Exception){

        }
    }

    fun updateFPL(tvCurrencyPerUSD: EditText) {
        try{

            if(pricePerGallon_i.editableText.isNotEmpty()&& currencyPerUSD_i.editableText.isNotEmpty()) {

                var pricePerUSGallon = (pricePerGallon_i.text.toString()).toDouble()
                var foreignCurrencyPerUSD = (tvCurrencyPerUSD.text.toString()).toDouble()
                var foreignCurPerLiter = (pricePerUSGallon/3.78541)*foreignCurrencyPerUSD

                yourCurrency.text= DecimalFormat("#.0#").format(foreignCurPerLiter)
            }else{
                yourCurrency.text="0.00"
            }
        }catch (inputEventSender: Exception) {

        }catch (MessageQueue: Exception){

        }catch(AndroidRuntime: Exception){

        }
    }

}

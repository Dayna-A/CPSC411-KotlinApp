package ca.daynaa.myminiapp1_anderson

import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.os.Bundle
import android.os.MessageQueue
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.pow
import kotlinx.android.synthetic.main.activity_main.*
/*How to use the kotlin extensions and which plugins needed to be applied was learned here:
  https://antonioleiva.com/kotlin-android-extensions/ */

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*The below Extension function was learned here
        https://kotlinlang.org/docs/reference/extensions.html
         */

        fun TextView.reCalculate(){
            try {
                if (this.editableText.isNotEmpty()) {
                    val networkSpeed = Integer.parseInt(networkSpeed!!.text.toString())
                    val fileSize = Integer.parseInt(file_Size!!.text.toString())
                    val networkSpeedBps = networkSpeed * (10.0).pow(6)
                    val fileSizeBits = fileSize * (2.0).pow(20) * 8
                    val transferTimeT = fileSizeBits / networkSpeedBps
                    transferTime.text = DecimalFormat("#.0#").format(transferTimeT)
                }else{
                    transferTime.text = "0"
                }
            }catch (inputEventSender: Exception) {

            }catch (MessageQueue: Exception){

            }catch(AndroidRuntime: Exception){

            }
        }

        /*The following text changed listeners implementation was learned here
        https://stacktips.com/tutorials/android/android-textwatcher-example*/

        /* Set Up text watch listeners for both EditText Items*/

        file_Size!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
               file_Size.reCalculate()

            }
        })
        networkSpeed!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                networkSpeed.reCalculate()

            }
        })
    }


}

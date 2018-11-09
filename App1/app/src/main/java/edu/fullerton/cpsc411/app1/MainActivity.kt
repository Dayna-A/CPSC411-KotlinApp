package edu.fullerton.cpsc411.app1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_row.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Grabbing the listview object from Main Activity
        val listView1 = findViewById<ListView>(R.id.menu_listview)

        //sets the listview adapter
        listView1.adapter = MyAdapter(this)

        //sets the click listener that depending on position will set an intent for the next activity
        listView1.setOnItemClickListener(object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position == 0) {
                    val intent = Intent(this@MainActivity, BMICalcActivity::class.java)
                    startActivity(intent)
                } else if (position == 1) {
                    val intent = Intent(this@MainActivity, BinaryCalcActivity::class.java)
                    startActivity(intent)
                } else if (position == 2) {
                    val intent = Intent(this@MainActivity, CelsiusFahrenheitCalcActivity::class.java)
                    startActivity(intent)
                } else if (position == 3) {
                    val intent = Intent(this@MainActivity, GasPriceActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }

    //here is our class that implements an adapter for the context returning to listview above
    private class MyAdapter(context: Context): BaseAdapter() {

        //val holding our context
        private val myContext: Context

        //val holding the name of calculators in listview
        private val calculators = arrayListOf<String>(
                "BMI Calculator",
                "Binary Calculator",
                "Temperature Calculator",
                "Gas Price Calculator"
        )

        private val descriptions = arrayListOf<String>(
                "Calculator to get your Body Mass Index",
                "Calculator for converting Binary to Decimal",
                "Calculator for converting Fahrenheit to Celsius",
                "Calculator for converting US Gas prices to Metric"
        )

        //init the context val
        init {
            myContext = context
        }


        //inflates the layout and sets each
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //create the inflater from the context and inflate the main_row.xml layout for style of each listview item
            val linflater = LayoutInflater.from(myContext)
            val mainRow = linflater.inflate(R.layout.main_row, parent, false)

            //grab the textView from mainrow called calcView
            val calculatorTV = mainRow.findViewById<TextView>(R.id.calcView)
            //set its text to item position from array in class
            calculatorTV.text = calculators.get(position)

            //grab the textView from mainrow called descriptionView
            val calculatorDescriptionTV = mainRow.findViewById<TextView>(R.id.descriptionView)
            //set its text to item position from array in class
            calculatorDescriptionTV.text = descriptions.get(position)

            //return the view inflated with custom name
            return mainRow
        }

        override fun getItem(position: Int): Any {
            return "TEST"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //this defines how many rows in the list
        override fun getCount(): Int {
            return calculators.size
        }
    }
}
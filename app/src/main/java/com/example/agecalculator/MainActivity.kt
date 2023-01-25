package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.Month
import java.time.MonthDay
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvselect : TextView? =null
    private var tvsel:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvselect = findViewById(R.id.text5)
        tvsel = findViewById(R.id.text7)
        val button : Button = findViewById(R.id.but1)


        button.setOnClickListener {

            calendarpicker()

            Toast.makeText(this,"This button is passed",Toast.LENGTH_SHORT).show()
            Log.i("but","pessed buuton")

        }

    }

    fun calendarpicker(){

        val MyCalendar = Calendar.getInstance()
        val year = MyCalendar.get(Calendar.YEAR)
        val month = MyCalendar.get(Calendar.MONTH)
        val day = MyCalendar.get(Calendar.DAY_OF_MONTH)

      val dpd =  DatePickerDialog(this,
            { view, year, month, dayOfMonth ->

            Log.i("case 1 ","DataPicker")
            Toast.makeText(this,"Year was $year in a month ${month+1}",Toast.LENGTH_SHORT).show()

            val selelect = "$dayOfMonth/${month+1}/$year"
                tvselect?.text = selelect

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selelect)

                val seldateinminute = theDate.time/60000

                val curentdate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val condateinminute = curentdate.time/60000

                val curentdateinminute = condateinminute - seldateinminute

                tvsel?.text = curentdateinminute.toString()

            },
            year,
            month,
            day
            )
        dpd.show()
        // set curent date
        dpd.datePicker.maxDate= System.currentTimeMillis() - 86400000
    }

}
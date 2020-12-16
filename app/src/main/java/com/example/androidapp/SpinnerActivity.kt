package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SpinnerActivity : AppCompatActivity() {


    private val languages = arrayOf(
        "Nepali", "Hindi",
        "English", "Chinese"
    )
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.spinner)
        // Array adapter
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_checked,
            languages
        )
        //Setting the adapter to spinner's adapter
        spinner.adapter = adapter
        // On item selected listener on spinner
        spinner.onItemSelectedListener =

            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   val selectedItem = parent?.getItemAtPosition(position).toString()
                    Toast.makeText(this@SpinnerActivity, selectedItem, Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
    }
}






package com.example.msharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var SharedPreference : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        SharedPreference = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val str1 = intent.getStringExtra("Name")
        val str2 = intent.getStringExtra("Hobby")

        textView.text = " Name: $str1 Hobby: $str2"




        button.setOnClickListener {
            val  NameS = SharedPreference.getString("Name", "")
            val  HobbyS = SharedPreference.getString("Hobby", "")
           textView.text = " Shared, Name: $NameS Hobby: $HobbyS"
        }
    }
}
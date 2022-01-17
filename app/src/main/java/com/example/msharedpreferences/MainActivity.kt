package com.example.msharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edName : EditText
    lateinit var etHobby : EditText
    lateinit var sharedPreferences: SharedPreferences


    lateinit var btIntent: Button
    lateinit var btShared: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.edName)
        etHobby = findViewById(R.id.etHobby)
        btIntent = findViewById(R.id.btIntent)
        btShared = findViewById(R.id.btShared)

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        btIntent.setOnClickListener {

            val intent = Intent(this , MainActivity2::class.java)
            intent.putExtra("Name" , edName.text.toString())
            intent.putExtra("Hobby" , etHobby.text.toString())
            startActivity(intent)
        }


        btShared.setOnClickListener {
            with(sharedPreferences.edit()){
                putString("Name",edName.text.toString() )
                putString("Hobby",etHobby.text.toString() )
                apply()
            }
        }
    }
}
package com.example.cheerify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private  lateinit var affirmation: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val refresh = findViewById<Button>(R.id.refresh_button)
        affirmation = String()
        getAffirmation()
        refreshAffirmation(refresh)
    }

    private fun getAffirmation(){

    }

    private fun refreshAffirmation(button: Button){
        button.setOnClickListener{
            getAffirmation()
        }
    }
}
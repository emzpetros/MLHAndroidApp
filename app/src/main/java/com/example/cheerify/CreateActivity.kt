package com.example.cheerify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CreateActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val homeCircle = findViewById<Button>(R.id.home_button)
        goToHome(homeCircle)

        val save = findViewById<Button>(R.id.save_affirmation)
        saveAffirmation(save)

    }

    private fun goToHome(button: Button){
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveAffirmation(button: Button){
        button.setOnClickListener{

        }
    }
}
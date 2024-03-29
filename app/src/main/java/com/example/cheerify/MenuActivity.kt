package com.example.cheerify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val homeCircle = findViewById<Button>(R.id.home_button)
        goToHome(homeCircle)

        val homeRounded = findViewById<Button>(R.id.home_rounded_button)
        goToHome(homeRounded)

        val customAffirmationButton = findViewById<Button>(R.id.custom_rounded_button)
        goToAdd(customAffirmationButton)
    }



    private fun goToHome(button: Button){
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToAdd(button: Button){
        button.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
    }

}
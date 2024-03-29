package com.example.cheerify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private  lateinit var affirmation: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val refresh = findViewById<Button>(R.id.refresh_button)
        affirmation = String()
        getAffirmation()
        refreshAffirmation(refresh)

        val menu = findViewById<Button>(R.id.menu_button)
        goToMenu(menu)
//        menu.setOnClickListener{
//            val intent = Intent(this, MenuActivity::class.java)
//            startActivity(intent)
//        }
        val add = findViewById<Button>(R.id.add_button)
        goToAdd(add)
    }

    private fun getAffirmation(){
        val client = AsyncHttpClient()
        val url = "https://www.affirmations.dev/"
        val textView = findViewById<TextView>(R.id.affirmation)
        client[url, object:
            JsonHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                if(json != null){
                    val affirmationText = json.jsonObject.getString("affirmation")
//                    jsonArray.getJSONObject(0).getString("affiramation")
                    textView.text = affirmationText
                }

            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                textView.text = "Failed"
            }
            }
        ]
    }

    private fun refreshAffirmation(button: Button){
        button.setOnClickListener{
            getAffirmation()
        }
    }

    private fun goToMenu(button: Button){
        button.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
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
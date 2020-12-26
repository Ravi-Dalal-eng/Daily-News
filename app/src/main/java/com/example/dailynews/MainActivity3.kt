package com.example.dailynews

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {
    lateinit var retry:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFFFFF")))

        // Set BackgroundDrawable
        supportActionBar?.setTitle(Html.fromHtml("<font color='#000000'>Daily News </font>"));
        retry=findViewById<Button>(R.id.retry)
        retry.setOnClickListener {


            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            val b= activeNetworkInfo != null && activeNetworkInfo.isConnected
if(b==true)
         startActivity(Intent(this@MainActivity3, MainActivity::class.java))
            else
    Toast.makeText(this@MainActivity3, "PLEASE CHECK YOUR INTERNET CONNECTION", Toast.LENGTH_SHORT).show()
        }
    }
}
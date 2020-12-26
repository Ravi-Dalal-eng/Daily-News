package com.example.dailynews

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity2 : AppCompatActivity() {
    lateinit var web:WebView
    lateinit var pro:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFFFFF")))

        // Set BackgroundDrawable
        supportActionBar?.setTitle(Html.fromHtml("<font color='#000000'>Daily News </font>"))
        web=findViewById<WebView>(R.id.webview)
        pro=findViewById<ProgressBar>(R.id.loading_spinner)
        val s: String? =intent!!.getStringExtra(Adapter.KEY)
        if(s!=null){
            web.loadUrl(s)
            web.settings.javaScriptEnabled = true
            web.webViewClient = object:WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?)
                {
                    super.onPageFinished(view, url)
                    pro.visibility=View.GONE
                    web.visibility=View.VISIBLE

                }
            }


        }
    }
}
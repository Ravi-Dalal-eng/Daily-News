package com.example.dailynews


import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//076dc3a0f6b4449f9437b7e1aa474a48
class MainActivity : AppCompatActivity() {
    companion object {
        var totalResults: Int =0

    }


lateinit var recc:RecyclerView
    lateinit var pp:ProgressBar
    lateinit var ppp:ProgressBar
    lateinit var chip1:Chip
    lateinit var chip2:Chip
    lateinit var chip3:Chip
    lateinit var chip4:Chip
    lateinit var chip5:Chip
    lateinit var chip6:Chip
    lateinit var chip7:Chip

 var lastcheck:Int=0
    var a=1

    var ll:ArrayList<Article> =ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFFFFF")))

        // Set BackgroundDrawable
                supportActionBar?.setTitle(Html.fromHtml("<font color='#000000'>Daily News </font>"));
        Log.d("Ravi Dalal", "$lastcheck $a")
         recc = findViewById<RecyclerView>(R.id.rec)
        pp=findViewById<ProgressBar>(R.id.p)
        ppp=findViewById<ProgressBar>(R.id.ppp)
        chip1=findViewById<Chip>(R.id.chip1)
        chip2=findViewById<Chip>(R.id.chip2)
        chip3=findViewById<Chip>(R.id.chip3)
        chip4=findViewById<Chip>(R.id.chip4)
        chip5=findViewById<Chip>(R.id.chip5)
        chip6=findViewById<Chip>(R.id.chip6)
        chip7=findViewById<Chip>(R.id.chip7)


        recc.layoutManager = LinearLayoutManager(this@MainActivity)
        recc.adapter = Adapter(this@MainActivity, ll)
         lastcheck=chip1.id
        Log.d("Ravi Dalal", "$lastcheck $a")
        chip1.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener

            chip1.setChipBackgroundColorResource(R.color.red)
            chip1.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))
            lastcheck=it.id
            networkRequest(1, "business")

        }
        chip2.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener


            chip2.setChipBackgroundColorResource(R.color.red)
            chip2.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))
            lastcheck=it.id
            networkRequest(1, "entertainment")
        }
        chip3.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener
            chip3.setChipBackgroundColorResource(R.color.red)
            chip3.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))

            lastcheck=it.id
            networkRequest(1, "general")
        }
        chip4.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener
            chip4.setChipBackgroundColorResource(R.color.red)
            chip4.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))

            lastcheck=it.id
            networkRequest(1, "health")
        }
        chip5.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener
            chip5.setChipBackgroundColorResource(R.color.red)
            chip5.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))

            lastcheck=it.id
            networkRequest(1, "science")
        }
        chip6.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener
            chip6.setChipBackgroundColorResource(R.color.red)
            chip6.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))
            lastcheck=it.id
            networkRequest(1, "sports")
        }
        chip7.setOnClickListener {
            // Responds to chip click
            if(it.id==lastcheck)
                return@setOnClickListener
            chip7.setChipBackgroundColorResource(R.color.red)
            chip7.setTextColor(getResources().getColor(R.color.white))
            (findViewById<Chip>(lastcheck) as Chip).setChipBackgroundColorResource(R.color.white)
            (findViewById<Chip>(lastcheck) as Chip).setTextColor(getResources().getColor(R.color.black))
            lastcheck=it.id
            networkRequest(1, "technology")
        }





networkRequest(1, "business")
    }
    fun networkRequest(p: Int, s: String){
        Log.d("Ravi Dalal", "$p " + s)
       var num :Call<News> = Provider.cal(Service::class.java).getHeadLines("in", p, s)
        if(p==1) {
            ppp.visibility=View.GONE
            ll.clear()
            (recc.adapter as Adapter).notifyDataSetChanged()
            Adapter.page=1
            pp.visibility = View.VISIBLE
            Log.d("Ravi Dalal", "$lastcheck ${ll.size}")
        }
            if(p==2){
            ppp.visibility=View.VISIBLE
                Log.d("Ravi Dalal", "$lastcheck ${ll.size}")}
          num.enqueue(object : Callback<News> {
              override fun onFailure(call: Call<News>, t: Throwable) {
                  startActivity(Intent(this@MainActivity, MainActivity3::class.java))
                  finish()
              }

              override fun onResponse(call: Call<News>, response: Response<News>) {
                  val vv = response.body()
                  Log.d("Ravi Dalal", "$lastcheck ${response.isSuccessful} ${response.body()?.totalResults}")
                  if (vv != null) {

                      ll.addAll(vv.articles)
                      Log.d("Ravi Dalal", "$lastcheck ${ll.size}")
                      totalResults = vv.totalResults
                      (recc.adapter as Adapter).notifyDataSetChanged()
                      pp.visibility = View.GONE
                      ppp.visibility = View.GONE
                      if (a == 1) {
                          a = a + 1
                          Toast.makeText(this@MainActivity, "Click On News To Know More...", Toast.LENGTH_LONG).show()
                      }
                      Log.d("Ravi Dalal", "$lastcheck $a")
                  }
              }
          })

        }



    }






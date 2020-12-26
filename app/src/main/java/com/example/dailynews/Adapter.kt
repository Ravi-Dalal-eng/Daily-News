package com.example.dailynews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


class Adapter(val c: Context, val articles: ArrayList<Article>):RecyclerView.Adapter<Adapter.MyView>()
{
companion object{
    val KEY:String="intent_key"
    var page=1
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
    return MyView(LayoutInflater.from(c).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
val ar=articles[position]
        if(ar.title.contains(" - "))
        holder.titel.text=ar.title.substring(0, ar.title.lastIndexOf(" - "))
        else
            holder.titel.text=ar.title
        if(ar.description!=null)
        holder.descr.text=ar.description
       holder.txtv.setOnClickListener {


           var share = Intent(Intent.ACTION_SEND)
           share.type = "text/plain"

           share.putExtra(Intent.EXTRA_SUBJECT, ar.title)
           share.putExtra(Intent.EXTRA_TEXT,ar.url)

           c.startActivity(Intent.createChooser(share, "Share news with"))
       }
     holder.ttl.text=ar.source.name
        var ss=ar.publishedAt
        var sss=ss.replace('-', '/').replace('T', ' ').replace('Z', ' ').trimEnd()
        var sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            var date: Date = sdf.parse(sss)
           var millis: Long = date.getTime()
      var currentMillis=System.currentTimeMillis()
    var yy:Long=currentMillis-millis
        var second=(yy/1000).toInt()
when
{
    second>604800 ->holder.tt2.text="1 week ago"
    second>518400 ->holder.tt2.text="6 days ago"
    second>432000 ->holder.tt2.text="5 days ago"
    second>345600 ->holder.tt2.text="4 days ago"
    second>259200 ->holder.tt2.text="3 days ago"
    second>172800 ->holder.tt2.text="2 days ago"
    second>86400 ->holder.tt2.text="1 day ago"
    second>82800 ->holder.tt2.text="23 hours ago"
    second>79200 ->holder.tt2.text="22 hours ago"
    second>75600 ->holder.tt2.text="21 hours ago"
    second>72000 ->holder.tt2.text="20 hours ago"
    second>68400 ->holder.tt2.text="19 hours ago"
    second>64800 ->holder.tt2.text="18 hours ago"
    second>61200 ->holder.tt2.text="17 hours ago"
    second>57600 ->holder.tt2.text="16 hours ago"
    second>54000 ->holder.tt2.text="15 hours ago"
    second>50400 ->holder.tt2.text="14 hours ago"
    second>46800 ->holder.tt2.text="13 hours ago"
    second>43200 ->holder.tt2.text="12 hours ago"
    second>39600 ->holder.tt2.text="11 hours ago"
    second>36000 ->holder.tt2.text="10 hours ago"
    second>32400 ->holder.tt2.text="9 hours ago"
    second>28800 ->holder.tt2.text="8 hours ago"
    second>25200 ->holder.tt2.text="7 hours ago"
    second>21600 ->holder.tt2.text="6 hours ago"
    second>18000 ->holder.tt2.text="5 hours ago"
    second>14400 ->holder.tt2.text="4 hours ago"
    second>10800 ->holder.tt2.text="3 hours ago"
    second>7200 ->holder.tt2.text="2 hours ago"
    second>3600 ->holder.tt2.text="1 hour ago"
    second>2700 ->holder.tt2.text="45 minutes ago"
    second>1800 ->holder.tt2.text="30 minutes ago"
    second>1200 ->holder.tt2.text="20 minutes ago"
    second>900 ->holder.tt2.text="15 minutes ago"
    second>600 ->holder.tt2.text="10 minutes ago"
    second>300 ->holder.tt2.text="5 minutes ago"
    second>120 ->holder.tt2.text="2 minutes ago"
    else ->holder.tt2.text="now"
}






if(ar.urlToImage!=null)
{
                Glide.with(c).load(ar.urlToImage).placeholder(R.drawable.load).centerCrop().into(holder.image)
}


if(position==articles.size-1)
{

    var r=(c as MainActivity).lastcheck
    if(articles.size!=MainActivity.totalResults)
    {
        ++page
        if(page==2)
        {
        if(r==(c as MainActivity).chip1.id)
        (c as MainActivity).networkRequest(page, "business")
        else if(r==(c as MainActivity).chip2.id)
            (c as MainActivity).networkRequest(page, "entertainment")
        else if(r==(c as MainActivity).chip3.id)
            (c as MainActivity).networkRequest(page, "general")
        else if(r==(c as MainActivity).chip4.id)
            (c as MainActivity).networkRequest(page, "health")
        else if(r==(c as MainActivity).chip5.id)
            (c as MainActivity).networkRequest(page, "science")
        else if(r==(c as MainActivity).chip6.id)
            (c as MainActivity).networkRequest(page, "sports")
        else (c as MainActivity).networkRequest(page, "technology")
        }
    }
}
        val value=ar.url
      holder.ll.setOnClickListener {
     var intent= Intent(c, MainActivity2::class.java)
       intent.putExtra(KEY, value)
      c.startActivity(intent)
 }
    }



    override fun getItemCount(): Int {
        return articles.size
    }

    class MyView(ite: View):RecyclerView.ViewHolder(ite){
        var titel=ite.findViewById<TextView>(R.id.text1)
        var descr=ite.findViewById<TextView>(R.id.text2)
        var image=ite.findViewById<ImageView>(R.id.img)
        var ll=ite.findViewById<LinearLayout>(R.id.item)
        var ttl=ite.findViewById<TextView>(R.id.tt1)
        var tt2=ite.findViewById<TextView>(R.id.tt2)
        var txtv=ite.findViewById<TextView>(R.id.txtv)
    }
}
package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    //var sharedPreferences : SharedPreferences ?= null
    lateinit var sharedPreferences: SharedPreferences // latenit ==> değeri sonradan girilecek değişken tipi
    private lateinit var binding: ActivityMain2Binding
    var numara =0
    var runnable:Runnable = Runnable{}
    var handler=Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent =intent
        val alinanVeri = intent.getStringExtra("yollananVeri")

        binding  = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text1.text=alinanVeri


        sharedPreferences= this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE) // ilk parametre paket adı verilir genelde , ikinci parametre mode private = sadece uygulama tarafından okunabilsin


    }
    /*fun onClickButton2(view: View)
    {
     // sharedPreferences
        var skor="10"
        sharedPreferences.edit().putString("skor",skor).apply()
        binding.textView2.text=sharedPreferences.getString("skor","0")
    }*/

/*    fun onClickButton2(view: View)
    {
        // Runnable Handler start
        numara =0
        runnable = object : Runnable{
            override fun run() {
                numara=numara+1
                binding.textView2.text="Sayac: ${numara} "
                handler.postDelayed(runnable,1000) // kaç saniyede bir çalıştırılacak
            }
        }
        handler.post(runnable) // runnable sürekli çalıştırıacak
    }*/

   /* fun onClickButton2(view: View)
    {
        // Runnable Handler stop
       handler.removeCallbacks(runnable)
        numara=0
        binding.textView2.text="Sayac: ${numara} "
    }*/

    fun onClickButton2(view: View)
    {
        val intent = Intent(applicationContext,KitapActivity::class.java)
        startActivity(intent);
    }


}
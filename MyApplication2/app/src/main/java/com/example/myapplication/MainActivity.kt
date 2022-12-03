package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View)
    {
        val aktarilacakVeri = "omer";
        val intent = Intent(applicationContext,MainActivity2::class.java)
        intent.putExtra("yollananVeri",aktarilacakVeri);
        startActivity(intent);
    }
}
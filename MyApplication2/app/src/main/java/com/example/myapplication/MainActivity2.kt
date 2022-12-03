package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent =intent
        val alinanVeri = intent.getStringExtra("yollananVeri")

        binding  = ActivityMain2Binding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.text1.text=alinanVeri

    }

}
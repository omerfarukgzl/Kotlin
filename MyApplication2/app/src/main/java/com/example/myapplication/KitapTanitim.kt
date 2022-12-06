package com.example.myapplication

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityKitapTanitimBinding


class KitapTanitim : AppCompatActivity() {

    private lateinit var binding: ActivityKitapTanitimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitap_tanitim)
        val intent =intent
        val alinanVeriKitapIsim = intent.getStringExtra("kitapIsim")
        binding  = ActivityKitapTanitimBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.kitapTanitimText.text=alinanVeriKitapIsim
        binding.kitapTaniitmImage.setImageBitmap(SingletonClass.gorsel)


    }






}
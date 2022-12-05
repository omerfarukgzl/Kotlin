package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityKitapBinding
import com.example.myapplication.databinding.RecyclerRowBinding

class KitapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKitapBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitap)

        // kitapları array listlerde saklayacağız

        var kitapIsimleri = ArrayList<String>()

        kitapIsimleri.add("kitap1")
        kitapIsimleri.add("kitap2")
        kitapIsimleri.add("kitap3")
        kitapIsimleri.add("kitap4")


        val kitap1Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap1)
        val kitap2Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap2)
        val kitap3Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap3)
        val kitap4Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap4)

        val gorselBitmapListesi=ArrayList<Bitmap>()
        gorselBitmapListesi.add(kitap1Bitmap)
        gorselBitmapListesi.add(kitap2Bitmap)
        gorselBitmapListesi.add(kitap3Bitmap)
        gorselBitmapListesi.add(kitap4Bitmap)

        val layoutManager = LinearLayoutManager(this)

        binding  = ActivityKitapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=layoutManager

        val recyclerAdapter = RecyclerAdapter(kitapIsimleri,gorselBitmapListesi)
        binding.recyclerView.adapter=recyclerAdapter


    }
}
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

        /*
        // verimsiz tanımlama

        val kitap1Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap1)
        val kitap2Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap2)
        val kitap3Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap3)
        val kitap4Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap4)

        val gorselBitmapListesi=ArrayList<Bitmap>()
        gorselBitmapListesi.add(kitap1Bitmap)
        gorselBitmapListesi.add(kitap2Bitmap)
        gorselBitmapListesi.add(kitap3Bitmap)
        gorselBitmapListesi.add(kitap4Bitmap)

        */


        //   verimli tanımlama  ==> Direk bitmap oluşturmak yerine klasorde neredeyse onu soyliyeceğiz(drawable)

        val kitap1DrawableId= R.drawable.kitap1
        val kitap2DrawableId= R.drawable.kitap2
        val kitap3DrawableId= R.drawable.kitap3
        val kitap4DrawableId= R.drawable.kitap4

        var kitapDrawableIdArrayList = ArrayList<Int>()
        kitapDrawableIdArrayList.add(kitap1DrawableId)
        kitapDrawableIdArrayList.add(kitap2DrawableId)
        kitapDrawableIdArrayList.add(kitap3DrawableId)
        kitapDrawableIdArrayList.add(kitap4DrawableId)



        val layoutManager = LinearLayoutManager(this)

        binding  = ActivityKitapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=layoutManager

        val recyclerAdapter = RecyclerAdapter(kitapIsimleri,kitapDrawableIdArrayList)
        binding.recyclerView.adapter=recyclerAdapter


    }
}
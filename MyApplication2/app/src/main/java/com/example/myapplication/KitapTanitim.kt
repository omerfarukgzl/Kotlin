package com.example.myapplication

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityKitapTanitimBinding


class KitapTanitim : AppCompatActivity() {

    private lateinit var binding: ActivityKitapTanitimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitap_tanitim)

        val intent =intent

        binding  = ActivityKitapTanitimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // alınan resource id int tipindeki verileri bitmape dönüştürdük
        val alinanVeriKitapGorsel = intent.getIntExtra("kitapGorsel",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,alinanVeriKitapGorsel)
        binding.kitapTanitmImage.setImageBitmap(bitmap)


        val alinanVeriKitapIsim = intent.getStringExtra("kitapIsim")
        binding.kitapTanitimText.text=alinanVeriKitapIsim

        //binding.kitapTaniitmImage.setImageBitmap(SingletonClass.gorsel)


    }

    fun onClickFragrment1Button(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = BlankFragment()
        fragmentTransaction.add(R.id.frameLayout,firstFragment).commit()

    }

    fun onClickFragrment2Button(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment = BlankFragment2()
        fragmentTransaction.add(R.id.frameLayout,secondFragment).commit()


    }



}
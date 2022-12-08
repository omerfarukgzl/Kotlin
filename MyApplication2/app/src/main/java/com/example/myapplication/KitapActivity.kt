package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityKitapBinding

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


        // SQLite veri tabanı olusturma ve verileri kaydetme


       /*
        openOrCreate ==> varsa aç yoksa veritabanını oluştur.
        veritabaniAdi="Kitaplar"
        mode= MODE_PRIVATE // sadece uygulama tarafından kullanılacak
        cursor = null
         veritabani.execSQL() ==> veritabanuı komutları yazılır

         */

        try{
            val veriTabani= this.openOrCreateDatabase("Kitaplar",MODE_PRIVATE,null) // Kitaplar diye veritabanı olustur
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS diniKitap (id INTEGER PRIMARY KEY , isim TEXT) ") // diniKitap adında tablo oluştur ve sutunlarının özellikleirini gir
            //veriTabani.execSQL("DROP TABLE diniKitap")


           /* for(name in kitapIsimleri )
                veriTabani.execSQL("INSERT INTO diniKitap (isim) VALUES ('$name')")*/

            //  veriTabani.execSQL("INSERT INTO diniKitap (isim,fiyat) VALUES ('ad',fiyat)") ==> diniKitap tablosuna ürün ekle

            //  cursor bir imleçtir sorgu sonucuna atanır ve bu cursor kullanılarak istenilen alan bulunur
            // while ile cursor, kendisine atanan sorgu sonucundaki gelen sonuç tablsounda hareket edebildiği son yere kadar gezdirilir == moveToNext()

            val cursor=veriTabani.rawQuery("SELECT * FROM diniKitap",null) // ---  selection args filtreleme özelliğidir biz şuan kullanmıyoruz
            //val cursor=veriTabani.rawQuery("SELECT * FROM diniKitap WHERE isim='kitap3'",null) // denilebilirdi

            // arama yapmak icin sutun numaralarını aldık . Manuel olarak 0 1 2 3 de diyeilirdik sutun index nosu
            val ıdCoulmnIndex = cursor.getColumnIndex("id")
            val isimCoulmnIndex = cursor.getColumnIndex("isim")

            while(cursor.moveToNext())
            {
                // println getInt , getString yapılmaısnın sebebi sutun alanındaki veri nasıl kaydedildiyse onun tipinde yazdırılır
                println("ID : ${cursor.getInt(ıdCoulmnIndex)}")
                println("Kitap Adı : ${cursor.getString(isimCoulmnIndex)}")

                // istenilen fieldın bulunması
                if(cursor.getString(isimCoulmnIndex).equals("kitap3"))
                {
                    println("!!!!! kitap 3 veritabında bulundu bulundu")
                }
            }
            cursor.close()
        }catch (e:Exception){
            println("!!! Ben Hata " + e)
        }





    }
}
package com.example.myapplication;

public class Notes {
    /*

    * wrap_content ==> içeriği kadar boyut al(kendi orj boyutu kadar)
    * match_parent ==> parent'ın boyutu kadar al (ebeveyn)
    * dp ==> density pixel (ekran çözünürlüğüne göre boyutlandırma)

    * Linear Layout = yan yana veya alt alta dizmek istediğmiz yapılar için kullanılır.
        constraint layout gibi istediğin yere koyamazsın
        orientation = horizontal , vertical ( yatay= yan yana , dikey= alt alta)


    * Relative Layout = componentlerin birbirine göre hizalanması için kullanılır. Çok fazla kullanılmaz
        (sağına soluna altına üstüne konumlandır)

    * Frame Layout = tek bir component kullanılacaksa bu layout kullanılır.

    * Grid Layout = Izgara görünümü için kullanılır.

*******************************************************************************************************************

Not/:  Her eklenilen activity AndroidManifest.xml dosyasında da eklenir. bu dosyada activityler görüntülenebilir.
    * intent filter = hangi activity altında duruyorsa o activity ilk açıldığında gösterilir.(Launcher)

Not/: view tarafından çağırılacak fonksiyonların parameteresine view:View yazılır

Not/: Button click için tetiklenecek fonskiyonun yazımında öncelikle button attribute altında onClick özelliğine bir fonskiyon adı verilir
        ve bu fonksiyon adının aynı adıyla bir fonksiyon yazılır. Arka planda bu iki işlem eşleşir.
        fun buttonClick(view:View) // view bu fonksiyon bir view tarafından çağırılır !!
        {

        }





********* Intent***************

    ==>Bir Activity‘ den başka bir Activity‘ e geçişi sağlayan veya bilgi aktarımını yapan bu Intent nesnesidir.

********* Intent***************






******** Veri Aktarma********

-- Intent ile --

/aktaran Activity
    val aktarilacakVeri = "omer";
    intent.putExtra("alinanVeri",aktarilacakVeri); // hashMap tarzı key value verilir . diğer activity de key ile alınır

/alan Activity
    private lateinit var binding: ActivityMain2Binding // view Binding ile view taradındaki componentlere erişimi açtık.
     binding  = ActivityMain2Binding.inflate(layoutInflater); // binding ile view bağladık
     val alinanVeri=intent.getStringExtra("alinanVeri"); // intent ile aktarılan veriyi aldık
     setContentView(binding.root) // binding nesnesine eriştik
     binding.text1.text=alinanVeri; // view tarafındaki text1 e aktarılan veriyi yazdık

******** Veri Aktarma********






********* Activity Yaşam Döngüsü ***********


onCreate()  ==> ilk oluşturulrken çağırılır birdaha çağırılmaz. Bir diğeride başka activity den intent ile gelirsek çağırılır.

onStart()   ==> create den sonra çağırılır.Ekran ilk açıldığında create den sonra ve her yeniden açıldığında çağırılır.

onResume()  ==> startdan sonra çağırılır.

onPause()   ==> activity kapandığında ( başka activity ye geçildiğinde ) ve uygulama kapatıldığında ( fakat çalışan uygulamalardan sililnmeden ) çağırılır.

onStop()    ==> pause den sonra çağırılır.

onDestroy() ==> uygulama kapandığında ( çalışan uygulamalardan silinince)


Not:// eğer bir activity ye birdaha dönülmeyecekse o activity destroy edilmeli !! ( Örneğin login activty) ---- finish();


********* Activity Yaşam Döngüsü ***********






*************** Context ********************

Context, uygulamanın herhangi bir zamandaki durumunu tutan bir objedir.

Uygulamanin kaynaklarına erişmeyi sağlayan Android İşletim sistemi tarafından implement edilmiş bir Interface’dir.
 Sıklıkla uygulamanın /res klasörunde bulunan kaynaklara (stringler, resim dosyaları vs.) erişimi sağlamak icin kullanılır.
  Bunun dışında yeni bir Activity başlatma, Intent’leri kullanma gibi işler de Context tarafından yapılır.


*************** Context ********************





***************Listener*********************

Diyelim ki internetten çalışanlarınızın verilerini çekiyorsunuz.
 Çektiğiniz veri, bir görsel de olabilir, 10 megabaytlık veri de.
  Bu sırada kullanıcı arayüzünde, kullanıcı swipe, scroll yapmak isteyebilir ya da ekrana random tıklıyor olabilir.
   Eğer internetten veri indirirken ya da büyük kapasiteli bir işlem yaparken async (senkronize olmayan) bir şekilde yapılmazsa kullanıcı arayüzü kilitlenir.
    Kullanıcı arayüzü kitlenirse, kullanıcının uygulaması kilitlenir hatta uygulama çökebilir.


Böyle bir olayın yaşanmaması için genelde bütün bu işlemler asyn bir şekilde çalıştırılır ve
  aynı zamanda işlem tamamlandığında, yani internetten veri geldiğinde ne yapılacağını yazdığımız bazı fonksiyonlar vardır.
    Bu fonksiyonlar callback function, listener function veya completion function olarak karşımıza çıkabilir. Bu örneği koda dökebilirsiniz.


***************Listener*********************






*************** Abstract Class *************
Abstract Class kullanılacağı zaman

object: diyerek kullanılır

örn: Geriye sayan sayaç
     object: CountDownTimer("1000","1000"){
            override fun onTick(millisUntilFinished: Long) {
                TODO("Not yet implemented")
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }

*************** Abstract Class *************







**************Shared Preferences************

Küçük kullanılacak verileri kaydetmek için kullanılır. (Örneğin en yüksek skor)
Uygulamanın klasorlerinde data dosyasında xml formatında saklanır.
uygulama silinince kaydedilen veri silinir
SharedPreferences saklanama tipi hashMap'e benzer


 var sharedPreferences : SharedPreferences ?= null // global olarak tanımladık  diğer functionlarda da kullanılsın
 lateinit var sharedPreferences: SharedPreferences // latenit ==> değeri sonradan girilecek değişken tipi

  sharedPreferences= this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE) // ilk parametre paket adı verilir genelde , ikinci parametre mode private = sadece uygulama tarafından okunabilsin

    fun onClickButtonSkor(view:View)
    {
        var skor="10"
        sharedPreferences.edit().putString("skor",skor).apply() // kaydetmek
        sharedPreferences.edit().remove("skor").apply() // silmek
        binding.textView2.text=sharedPreferences.getString("skor","0")
    }
    bu fonksiyonda da basitçe bir değişkeni sharedpreferences da kaydettik ve o kaydettiğimiz değeri sharedPreferences dan alıp okuduk ve kullanıcıya gösterdik

**************Shared Preferences************







************* Runnable Handler *************

 Arka planda çalışan, belirli aralıklar ile tekrarlanmasını istediğimiz olayları yönetmemizi sağlayan esnek yapılardır.

************* Runnable Handler *************



Not::// Bir Xml ile kod birbirine bağlanacaksa Inflater kullanılır



**************** Recycler View *************
Bileşenleri listelemek istersek bu yapıyı kullanırız

Bileşenleri RecyclerView e bağlamak ve tek bir satır görünrüsünde tüm bileşenleri aynı satır görüntüsüyle gösterebilmek için
    layout altında yeni bir layout Resource file açtık
    bu xml görünümü bizim recyclerView daki tek bir satıra denk gelir

    Daha sonra bu layout Resource filedaki görünümü recyler view ile bağlamak için "" Recycler Adapter "" yazılır.


******* RecyclerAdapter *******
    class RecyclerAdapter(kitapGorselListesi : ArrayList<String>) : RecyclerView.Adapter<KitapViewHolder>() {
        // Bu adapter'in Bir Adapter olduğunu belirtmek için Adapter abstract classını extend ettik
        // Daha sonra Adapter Classıda bir ViewHolder istediği için KitapViewHolder adında class oluşturduk

            class KitapViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
                // KitapViewHolder sınıfı bir ViewHolder olduğu için ViewHolder classını implement ettik
                // ViewHolder classı bir itemView istediği için KitapViewHolder primary consturctore 'ında itemView istedik ve parametre olarak aldığımız itemViewi verdik

        // Adapter Classının functionları override edildi
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapViewHolder {
// ViewHolder için bağlanacak görüntüyü tanımladık
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return  KitapViewHolder(itemView) // viewHolder döndürdük

        }
        //
        override fun onBindViewHolder(holder: KitapViewHolder, position: Int) {
          // recycler view içerisindeki elemanlara ulaşırız ve text e position ile her elemanı satırdaki textlere atanır
          holder.itemView.findViewById<TextView>(R.id.recyclerViewkitapAdText).text=kitapGorselListesi.get(position)
        }

        override fun getItemCount(): Int {
            // rcycler View içerisinde kaç tane satır olacak
            // (kitapGorselListesi : ArrayList<String>) ==> bu listenin eleman sayısına ıulaşmak için constructor da listeyi aldık
            val satırSayisi = kitapGorselListesi.size
            return satırSayisi
        }







**************** Recycler View *************


Not :// Görselleri nesneleştirmek için Bitmap kullanılır
val kitap1Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap1) //applicatiomContext.resources ==> uygulamanın kaynaklarına ulaştık  R.drawable.kitap1==> resmin id sini veredik id= ad

Not:// oluşturulan bitMapler tümü kullanılacaksa ArrayList te Bitmap Türünde sakala





     */

}

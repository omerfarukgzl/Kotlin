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






0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000







---------------- Intent --------------------

    ==>Bir Activity‘ den başka bir Activity‘ e geçişi sağlayan veya bilgi aktarımını yapan bu Intent nesnesidir.

    Not !! büyük veriler yollanmaz örneğin Bitmap yollanmaz !!!!!!!

---------------- Intent --------------------






0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000









---------------------- Veri Aktarma-------------------

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

---------------------- Veri Aktarma-------------------





0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000






------------------- Activity Yaşam Döngüsü -------------------


onCreate()  ==> ilk oluşturulrken çağırılır birdaha çağırılmaz. Bir diğeride başka activity den intent ile gelirsek çağırılır.

onStart()   ==> create den sonra çağırılır.Ekran ilk açıldığında create den sonra ve her yeniden açıldığında çağırılır.

onResume()  ==> startdan sonra çağırılır.

onPause()   ==> activity kapandığında ( başka activity ye geçildiğinde ) ve uygulama kapatıldığında ( fakat çalışan uygulamalardan sililnmeden ) çağırılır.

onStop()    ==> pause den sonra çağırılır.

onDestroy() ==> uygulama kapandığında ( çalışan uygulamalardan silinince)


Not:// eğer bir activity ye birdaha dönülmeyecekse o activity destroy edilmeli !! ( Örneğin login activty) ---- finish();


------------------- Activity Yaşam Döngüsü -------------------







0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000








------------------------ Inflater -------------------------

XML görüntülerin View objelerine çevrilmesi için kullanılır. Daha sonra bu view objesi ekranda gösterilebeilir

Çok fazla kaynak tüketir bellek harcar bundan dolayı optimizasyonu iyi yapılmalı

getSystemServive() veya getLayoutInflater() denilerek kullanılabilir

çevrilecek XML in R.layout üzerinde kayıtlı olması lazım . Dinamik bir layout söz konusu değil


------------------------ Inflater -------------------------






0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000





-------------------- Context -----------------------

Context, uygulamanın herhangi bir zamandaki durumunu tutan bir objedir.

Uygulamanin kaynaklarına erişmeyi sağlayan Android İşletim sistemi tarafından implement edilmiş bir Interface’dir.
 Sıklıkla uygulamanın /res klasörunde bulunan kaynaklara (stringler, resim dosyaları vs.) erişimi sağlamak icin kullanılır.
  Bunun dışında yeni bir Activity başlatma, Intent’leri kullanma gibi işler de Context tarafından yapılır.


-------------------- Context -----------------------





0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000





------------------- Listener --------------------------

Diyelim ki internetten çalışanlarınızın verilerini çekiyorsunuz.
 Çektiğiniz veri, bir görsel de olabilir, 10 megabaytlık veri de.
  Bu sırada kullanıcı arayüzünde, kullanıcı swipe, scroll yapmak isteyebilir ya da ekrana random tıklıyor olabilir.
   Eğer internetten veri indirirken ya da büyük kapasiteli bir işlem yaparken async (senkronize olmayan) bir şekilde yapılmazsa kullanıcı arayüzü kilitlenir.
    Kullanıcı arayüzü kitlenirse, kullanıcının uygulaması kilitlenir hatta uygulama çökebilir.


Böyle bir olayın yaşanmaması için genelde bütün bu işlemler asyn bir şekilde çalıştırılır ve
  aynı zamanda işlem tamamlandığında, yani internetten veri geldiğinde ne yapılacağını yazdığımız bazı fonksiyonlar vardır.
    Bu fonksiyonlar callback function, listener function veya completion function olarak karşımıza çıkabilir. Bu örneği koda dökebilirsiniz.


------------------- Listener --------------------------




0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000





---------------------- Abstract Class -----------------------
Abstract Class kullanılacağı zaman

object: diyerek kullanılır

örn: Geriye sayan sayaç
     object: CountDownTimer("1000","1000"){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

            }

        }

---------------------- Abstract Class -----------------------





0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000





----------------------- Shared Preferences -------------------------

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


----------------------- Shared Preferences -------------------------






0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000






 --------------------------- Runnable Handler ---------------------------

 Arka planda çalışan, belirli aralıklar ile tekrarlanmasını istediğimiz olayları yönetmemizi sağlayan esnek yapılardır.

--------------------------- Runnable Handler ---------------------------




Not::// Bir Xml ile kod birbirine bağlanacaksa Inflater kullanılır







0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000




---------------------- Singelton Class ---------------------------

## Singleton nesne nedir:
 Singleton classın bir nesnesi oluşturulur ve o nesne tüm class larda kullanılabilir.
 Fakat bu nesnede bir özellik değişirse diğer classların kullandığında da değişir ( static e benzer)

                   class SingletonClass {

                    companion object secilenKitap {
                    var gorsel : Bitmap?= null
                       }
                   }


---------------------- Singelton Class ---------------------------








0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000









--------------------------- Recycler View ---------------------------
https://medium.com/i%CC%87yi-programlama/kotlinde-recyclerview-kullan%C4%B1m%C4%B1-c7d533c1da72


--- Recycler View nedir

    Bileşenleri listelemek istersek bu yapıyı kullanırız
    Verileri listelemek için kullanılan bir yapıdır.
    Scroll (kaydırma) işleminin yapılmasını sağlar.
    Listview’in daha gelişmiş ve esnek bir sürümüdür.


---  Recyclerivew’ın Yararları

     Default olarak, RecyclerView yalnızca ekranda görüntülenmekte olan item’leri işlemek veya çizmek için çalışır.
     Örneğin, listenizde bin item varsa ancak ekranda yalnızca 10 item görünürse,
     RecyclerView ekranda yalnızca 10 item çizecek kadar iş yapar. Kullanıcı kaydırdığında,
     RecyclerView ekranda yeni item’lerin ne olması gerektiğini bulur ve bu item’leri görüntülemek için işlem yapar.


--- Recycler View Oluşturmak İçin Gerkenler

    * Adapter
    * LayoutManager
    * ViewHolder

📍 Adapter

Adapter verileri RecyclerView’e bağlar. Verileri bir ViewHolder içinde görüntülenebilecek şekilde uyarlar. RecyclerView, verilerin ekranda nasıl görüntüleneceğini anlamak için adapter kullanır.

 📍 Layout Manager

Bu nesne RecyclerView’in itemlerini konumlandırır ve ekran dışında geçiş yapan itemlerin ne zaman geri dönüştürüleceğini söyler.

Default olarak Layout Manager 3 seçenek sunar.

→ LinearlayoutManager : İtemleri standart ListView şeklinde görünmesini sağlar.

→ GridLayoutManager : İtemlerin satır ve sütun şeklinde görünmesini sağlar.

→ StaggeredGridLayoutManager : İtemlerin kademeli satır ve sütun şeklinde görünmesini sağlar.


 📍 ViewHolder

Her itemin içinde bulunan bileşenlerin tanımlama işleminin yapıldığı yerdir.





Bileşenleri RecyclerView e bağlamak ve tek bir satır görünrüsünde tüm bileşenleri aynı satır görüntüsüyle gösterebilmek için
    layout altında yeni bir layout Resource file açtık
    bu xml görünümü bizim recyclerView daki tek bir satıra denk gelir

    Daha sonra bu layout Resource filedaki görünümü recyler view ile bağlamak için "" Recycler Adapter "" yazılır.

    Verimsiz bir şekilde kitap isim ve gorsel arraylist leri oluşturup recycler view e aktardık
    Bu tarz aktarım verimsizdir fakat test etmek için deniyoruz aşağıda verimli halinide yazdık





        -----**** Kod ****------  // verimsiz tanımlama
        Not:  bitmap aktarımında singleton class kullandık


            private lateinit var binding: ActivityKitapBinding // view deki componente erişme

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
                binding.recyclerView.layoutManager=layoutManager // İtemleri standart ListView şeklinde görünmesini sağlar.

                val recyclerAdapter = RecyclerAdapter(kitapIsimleri,gorselBitmapListesi)
                binding.recyclerView.adapter=recyclerAdapter // recycler view adapter ına oluşturduğumuz layout u ekliyoruz




            -----**** Kod ****------  // verimlitanımlama
            Direk bitmap oluşturmak yerine klasorde neredeyse onu soyliyeceğiz(drawable)

             val kitap1DrawableId= R.drawable.kitap1
             val kitap2DrawableId= R.drawable.kitap2
             val kitap3DrawableId= R.drawable.kitap3
             val kitap4DrawableId= R.drawable.kitap4

            var kitapDrawableIdArrayList = ArrayList<Int>()
            kitapDrawableIdArrayList.add(kitap1DrawableId)
            kitapDrawableIdArrayList.add(kitap2DrawableId)
            kitapDrawableIdArrayList.add(kitap3DrawableId)
            kitapDrawableIdArrayList.add(kitap4DrawableId)




        ------ Adapter class'ında değişiklikler  ==> Bitmap aktarılmadı Resource file ind id listesi aktarıldı

            ArrayList Int oldu
            ==> class RecyclerAdapter(val kitapGorselListesi : ArrayList<String>,val kitapGorselleri : ArrayList<Int>) : RecyclerView.Adapter<KitapViewHolder>() {



            yeni arraylist position secildi ve singelton class kaldırıldı
             override fun onBindViewHolder(holder: KitapViewHolder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.recyclerViewkitapAdText).text=kitapGorselListesi.get(position)
       ==>  holder.itemView.findViewById<ImageView>(R.id.imageView).setImageResource(kitapGorselleri.get(position))
            holder.itemView.setOnClickListener{
                val kitapIsim = kitapGorselListesi.get(position);
       ==>      val kitapGorsel = kitapGorselleri.get(position)
                val intent = Intent(holder.itemView.context,KitapTanitim::class.java)
                intent.putExtra("kitapIsim",kitapIsim);
       ==>      intent.putExtra("kitapGorsel",kitapGorsel);

            }


      ------ Kitap Tanıtim class'ında değişiklikler  ==> alınan resource id int tipindeki verileri bitmape dönüştürdük


            val intent =intent

            binding  = ActivityKitapTanitimBinding.inflate(layoutInflater)
            setContentView(binding.root)

    ==>     // alınan resource id int tipindeki verileri bitmape dönüştürdük
            val alinanVeriKitapGorsel = intent.getIntExtra("kitapGorsel",0)
            val bitmap = BitmapFactory.decodeResource(applicationContext.resources,alinanVeriKitapGorsel)
            binding.kitapTanitmImage.setImageBitmap(bitmap)


            val alinanVeriKitapIsim = intent.getStringExtra("kitapIsim")
            binding.kitapTanitimText.text=alinanVeriKitapIsim

      ==>   //binding.kitapTaniitmImage.setImageBitmap(SingletonClass.gorsel)



----------******  RecyclerAdapter *********----------------


ItemListAdapter bizden 3 methodu override etmemizi isteyecek. Bunlar;

→ onCreateViewHolder( ): Adapter oluşturulduğunda ViewHolder’ı başlatıyor.

→ getItemCount( ): Listemizin eleman sayısını veriyor.

→ onBindViewHolder( ) : onCreateViewHolder’dan dönen verilerin bağlama işlemini gerçekleştiriyor.



    class RecyclerAdapter(kitapGorselListesi : ArrayList<String>) : RecyclerView.Adapter<KitapViewHolder>() {

        // Bu adapter'in Bir Adapter olduğunu belirtmek için Adapter abstract classını extend ettik
        // Daha sonra Adapter Classıda bir ViewHolder istediği için KitapViewHolder adında class oluşturduk

            class KitapViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

                // KitapViewHolder sınıfı bir ViewHolder olduğu için ViewHolder classını implement ettik
                // ViewHolder classı bir itemView istediği için KitapViewHolder primary consturctore 'ında itemView istedik ve parametre olarak aldığımız itemViewi verdik




         Adapter Classının functionları override edildi

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapViewHolder {
        // ViewHolder için bağlanacak görüntüyü tanımladık

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
            return  KitapViewHolder(itemView) // viewHolder döndürdük

        }



        override fun onBindViewHolder(holder: KitapViewHolder, position: Int) {

          // recycler view içerisindeki elemanlara ulaşırız ve text e position ile her elemanı satırdaki textlere atanır
          // recycler view içerisindeki satırlara tıklanınca tanıtım sayfasına gitmesi için setOnClick Listener ile dinledik
                ve kitap ismini Intent ile Kitap Gorselini Singleton class ile gönderdik
                Çünkü Intent ile büyük veriler başka activity'e aktarılamaz uygulama çöker
                Zaten resimler genellikle başka Activitye aktarılmazlar bu verimsiz iştir fakat denemek için yazıyoruz

            holder.itemView.findViewById<TextView>(R.id.recyclerViewkitapAdText).text=kitapGorselListesi.get(position)
            holder.itemView.findViewById<ImageView>(R.id.imageView).setImageBitmap(kitapGorselBitmap.get(position))
            holder.itemView.setOnClickListener{
            val kitapIsim = kitapGorselListesi.get(position);
            val intent = Intent(holder.itemView.context,KitapTanitim::class.java)
            intent.putExtra("kitapIsim",kitapIsim);
            val secilenKitap = SingletonClass.secilenKitap
            secilenKitap.gorsel=kitapGorselBitmap.get(position)
            holder.itemView.context.startActivity(intent);

            }
        }



        override fun getItemCount(): Int {
            // rcycler View içerisinde kaç tane satır olacak
            // (kitapGorselListesi : ArrayList<String>) ==> bu listenin eleman sayısına ıulaşmak için constructor da listeyi aldık

            val satırSayisi = kitapGorselListesi.size
            return satırSayisi
        }


----------******  RecyclerAdapter *********----------------




--------------------------- Recycler View ---------------------------


Not :// Görselleri nesneleştirmek için Bitmap kullanılır
val kitap1Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kitap1) //applicatiomContext.resources ==> uygulamanın kaynaklarına ulaştık  R.drawable.kitap1==> resmin id sini veredik id= ad

Not:// oluşturulan bitMapler tümü kullanılacaksa ArrayList te Bitmap Türünde sakala








0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000






--------------------------- Fragment ---------------------------

-- Fragment Nedir ?
    Bir kullanıcı ara yüzüdür.
    Uygulamalarımızda her zaman birden fazla ekran kullanmaya ihtiyaç vardır.
    Fragmentler sayesinde birden fazla ekran kullanabiliriz.
    Tek bir ekranı iki farklı işlev için kullanılır.
    Fragmentler Activity olmadan çalışamazlar.

    Fragmentler acitvity içerisinde fragment manager ile yönetilirler. Fragmentlerin de kendilerine ait bir yaşam döngüsü vardır.
    Kendi olaylarını kendisi halleder.
    Yani activity çalışmaya devam ederken düzenleme yapılabilir.
    Aynı ekranda bağımsız olarak kullanılabilir.

    Not://  !!️
    Activityler Fragmentlerin yaşam döngülerinden etkilenmezler. Ancak Fragmentler Activity lerin yaşam döngülerinden etkilenirler.





    -- Fragment Yaşam Döngüsü

        onAttach()          ==> Fragment ilk activity'e eklenir. Referans olarak eklendiği context'i alır

        onCreate()          ==> Fragment oluşturulduğunda bu metod çağırılır. Referans olarak Bundle objesi alır. Fragment 'i çalıştıracak olan kurucu fonk. çağırılır

        onCreateView()      ==> Fragmentların view e ilk eklenirken çağırılan metoddur. Mutlaka fragment layoutun çatısı olan view geri döndürmelidir. eğer layout içermiyorsa null döndürür

        onActivityCreated() ==> Activitylerin create metdou bittikten sonra çağırılır. activity nin UI nesnelerine erişmeye çalışmadan önce activity oluşumu tamamlandığın gösterir

        onStart()           ==> Fragment görünür olduğunda çağırılır

        onResume()          ==> Fragment 'ın kullanıcı ile etkileşime geçtiğ yerdir. Activity nin onResume methodundan sonra çağırılır.

        onPause()           ==> Fragment in kullanıcı ile etkileşimi sonlandığında çağırılır.

        onStop()            ==> Fragment in kullanıcıya görünür olmadığı zaman çağırılır.Activity durduğunda fragment da durur.

        onDestroyView()     ==> Sonlanma evresine girer fargment UI kaynakları temizlenir

        onDestroy()         ==> Fragment kalan son kaynakları da temizlenmesi için çağırılır

        onDeattach()        ==> Fragment bulunduğu activityden ayrıldığında çağırılır



🔑 Genellikle fragment içeren aktivite için en azından aşağıdaki metotlar implement edilmelidir.

onCreate()
onCreateView()
onPause()

🔑 Her bir Fragment Transaction (Fragmentlar arası işlem) aktivite tarafından yönetilen Back Stacke kaydedilmelidir.
 Back stack fragmentın metotlarının geriye dönük olarak çalıştırılabilmesini sağlar.

🔑 Oluşturulma sürecinde hem aktivitede hem de fragmentta bulunan ve aynı adı taşıyan metotlardan aktivitenin metodu önce fragment metodu daha sonra çalışır.





    Fragmentlar oluşturulur.
    Daha sonra xml kısımlarında göstermek istediğimiz componentler eklenir
    Daha sonra fragment ları bağlayacağımız activity'e iki buton ekledik farklı fragmentlar'ı test etmek için
    Daha sonra bu buttonların click methodlarını hazırladık
    Daha sonra Activity üzerinde göstereceğimiz fragment ların nasıl ve ne içinde gösterileceğini berlirlemek için framelayout ekledik acticty'e




--------------------------- Fragment ---------------------------










0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000











--------------------------- Navigation ---------------------------


Öncelikle navigation'u projemize implemet etmeliyiz.

dependencies {
  def nav_version = "2.3.0-alpha02"
  // Kotlin
  implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
  implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

  // Testing Navigation
  androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
}




 --Navigation Nedir

    Navigation, kullanıcıların uygulamanızdaki içerikler arasındaki gezintilerine ya da içeriklere girdikten sonra geri çıkmasına verilen isimdir.
    Peki kendimiz manuel olarak bu gezintileri yönetebiliyorken, navigation bileşeni bize ne sağlar?
    Navigation component belirlenmiş ilkelere bağlı kalarak tutarlı ve öngörülü bir kullanıcı deneyimi verebilmemiz için bize kolaylık sağlar.
    Yani bir kullanıcının girmiş olduğu içerikte back butonuna bastığında davranması gereken işi kendi yönetir.



 --  Navigation bileşeninin avantajları;

    Fragment geçiş işlemlerini handle eder.
    Geri butonu işlevini varsayılana göre düzenler.
    Animasyonlar ve geçiş işlemleri için standartlaştırılmış kaynaklar sağlar.
    Deep linking işlemini handle eder.
    Navigation UI pattern içerir (navigation drawers, bottom navigation vs).
    Navigation Editor, hazırladığınız navigation graph’ı görmek veya düzenleyebilmek için kolaylık sağlar.


 -- Navigation Graph

    Res altında new android resource file diyoruz. Resource de navigation seçilir. adına navigation_graph denir genelde. Büyük karakter olmamalı
    Daha sonra bir navigation graph oluşturuyoruz.
    Bu oluşturduğumuz xml aslında tüm geçişleri ve hedef fragmentlerinizi belirlediğiniz bir kaynak dosyasıdır.
    Aşağıdaki figürde her bir ekran bir fragmentı, oklar ise geçişleri temsil eder.

    Daha sonra fragmentlar içerisinde onclick yerine setOnClickListener kullanarak yazabilirz.

    Veri aktarımı yapılacağı zaman argument oluşturulmalıdır. Hangi tipte ise gönderielecek veri o tipte seçilmelidir


 -- Navigation Activty Üzerinde Navaigation Fragment Gösterimi

    Bileşenlerden Navhost Fragment seçilir ve oluşturduğumuz graph eklenir. Böylece göstermek istediğimiz fragmentler bağlanmış olur .( Manule bağlamadan farkllı olarak graph ile otomatik bğlanır)





 -- Navigation Fragment arguments iletimi

     view.findViewById<Button>(R.id.button4).setOnClickListener{
            val gonderilecekVeri = binding?.textView5?.text.toString()
            val bundle = bundleOf("veri" to gonderilecekVeri)
            Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_blankFragment2,bundle)
        }

        button'a basıldığı zaman gönderielecek veri viewBinding ile textView üzerinden alınır ve bu veri bundle ile findNavController.navigate kullanılarak fragment2 ye akatılır.


--------------------------- Navigation ---------------------------









0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000










------------------------------- SQLite ---------------------------------


 -- SQLite Nedir ?

    Local VeriTabandır. Cihazda Gömülü olarak saklanır.( Not alma uygulaması buna bir örnektir) uygulama silinince veriler de silinir. Data klasoru altında saklanır.


    SQLite, SQL ile uyumlu ilişkisel bir veritabanıdır.
    MySQL ve PostgreSQL gibi diğer SQL tabanlı sistemlerin aksine SQLite, istemci-sunucu mimarisi kullanmaz.
    Tüm program, uygulamalara entegre edilmiş bir C kütüphanesinde bulunur.
    Veritabanı, yoğun kaynak kullanan bağımsız süreçleri ortadan kaldırarak programın ayrılmaz bir parçası haline gelir.

    SQLite, verilerini tek bir platformlar arası dosyada saklar.
     Özel bir sunucu veya özel dosya sistemi olmadığından, SQLite'ı "dağıtmak", kitaplığını bağlamak ve yeni bir normal dosya oluşturmak kadar kolaydır.

    Bu basitlik, SQLite'ın uygulamalar ve gömülü cihazlar için tercih edilen veritabanı sistemi olarak büyük ölçüde benimsenmesine yol açmıştır.
    SQLite dağıtımlarının toplam sayısının diğer tüm veritabanı motorlarını aştığına inanılıyor kombineçünkü tüm büyük işletim sistemleri, çoğu programlama dili, kapsamlı bir yerleşik donanım listesi ve birçok önemli yazılım ürünü ile birlikte gelir.


 -- Veritabanını oluşturmak.

        openOrCreate ==> varsa aç yoksa veritabanını oluştur.
        veritabaniAdi="Kitaplar"
        mode= MODE_PRIVATE // sadece uygulama tarafından kullanılacak
        cursor = null
         veritabani.execSQL() ==> veritabanuı komutları yazılır



        try{
        val veriTabani= this.openOrCreateDatabase("Kitaplar",MODE_PRIVATE,null) // Kitaplar diye veritabanı olustur
        veriTabani.execSQL("CREATE TABLE IF NOT EXISTS diniKitap (id INTEGER PRIMARY KEY , isim TEXT) ") // diniKitap adında tablo oluştur ve sutunlarının özellikleirini gir
        //veriTabani.execSQL("DROP TABLE diniKitap")


         for(name in kitapIsimleri )
                veriTabani.execSQL("INSERT INTO diniKitap (isim) VALUES ('$name')")

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

------------------------------- SQLite ---------------------------------








0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000














     */

}

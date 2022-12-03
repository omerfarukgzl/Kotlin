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



****** Activity Yaşam Döngüsü ***********


onCreate()  ==> ilk oluşturulrken çağırılır birdaha çağırılmaz. Bir diğeride başka activity den intent ile gelirsek çağırılır.

onStart()   ==> create den sonra çağırılır.Ekran ilk açıldığında create den sonra ve her yeniden açıldığında çağırılır.

onResume()  ==> startdan sonra çağırılır.

onPause()   ==> activity kapandığında ( başka activity ye geçildiğinde ) ve uygulama kapatıldığında ( fakat çalışan uygulamalardan sililnmeden ) çağırılır.

onStop()    ==> pause den sonra çağırılır.

onDestroy() ==> uygulama kapandığında ( çalışan uygulamalardan silinince)












     */

}

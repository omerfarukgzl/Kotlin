package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val kitapGorselListesi : ArrayList<String>,val kitapGorselleri : ArrayList<Int>) : RecyclerView.Adapter<KitapViewHolder>() {

    /*fun RecyclerAdapter()
    {

    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false) // ViewHolder için bağlanacak görüntüyü tanımladık
        return  KitapViewHolder(itemView) // viewHolder döndürdük

    }

    override fun onBindViewHolder(holder: KitapViewHolder, position: Int) {
        // recycler view içerisindeki elemanlara ulaşırız
        holder.itemView.findViewById<TextView>(R.id.recyclerViewkitapAdText).text=kitapGorselListesi.get(position)
        holder.itemView.findViewById<ImageView>(R.id.imageView).setImageResource(kitapGorselleri.get(position))
        holder.itemView.setOnClickListener{
            val kitapIsim = kitapGorselListesi.get(position);
            val kitapGorsel = kitapGorselleri.get(position)
            val intent = Intent(holder.itemView.context,KitapTanitim::class.java)
            intent.putExtra("kitapIsim",kitapIsim);
            intent.putExtra("kitapGorsel",kitapGorsel);



            /*
            val secilenKitap = SingletonClass.secilenKitap
            secilenKitap.gorsel=kitapGorselBitmap.get(position)
            */
            holder.itemView.context.startActivity(intent);

        }
    }

    override fun getItemCount(): Int {
        // rcycler View içerisinde kaç tane satır olacak
        // (val kitapGorselListesi : ArrayList<Bitmap>) ==> bu listenin eleman sayısına ıulaşmak için constructor da listeyi aldık
        val satırSayisi = kitapGorselListesi.size
        return satırSayisi
    }

}
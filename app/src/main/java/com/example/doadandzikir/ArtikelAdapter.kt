package com.example.doadandzikir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ArtikelAdapter (private val listArtikel:ArrayList<Artikel>) :RecyclerView.Adapter<ArtikelAdapter.MyviewHolder>(){

    inner class MyviewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyviewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_artikel,parent,false)
    )

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val holderImage = holder.imgArtikel
        holderImage.apply {
            setImageResource(listArtikel[position].imageArtikel)
            setOnClickListener{
                val intent = Intent(context, DetailArtikelActivity::class.java)
                intent.putExtra(DetailArtikelActivity.DATA_TITLE, listArtikel[position].titleArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_DESC, listArtikel[position].descArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_IMAGE, listArtikel[position].imageArtikel)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = listArtikel.size
}
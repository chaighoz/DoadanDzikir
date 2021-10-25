package com.example.doadandzikir

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailArtikelActivity : AppCompatActivity() {
    companion object{
        const val DATA_TITLE = "title"
        const val DATA_DESC = "desc"
        const val DATA_IMAGE = "image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islam"
        setContentView(R.layout.activity_detail_artikel)

        val dataTitle = intent.getStringExtra(DATA_TITLE)
        val dataDesc = intent.getStringExtra(DATA_DESC)
        val dataIMage = intent.getIntExtra(DATA_IMAGE, 0)

        val tvTitle = findViewById<TextView>(R.id.tv_title_artikel)
        tvTitle.text = dataTitle
        val tvDesc = findViewById<TextView>(R.id.tv_desc_artikel)
        tvDesc.text = dataDesc
        val imgArtikel = findViewById<ImageView>(R.id.img_artikel)
        imgArtikel.setImageResource(dataIMage)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
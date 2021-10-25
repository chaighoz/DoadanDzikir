package com.example.doadandzikir

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var llQauliyahShalat: LinearLayout
    private lateinit var llSetiapSaatDzikir: LinearLayout
    private lateinit var llHarianDzikirDoa: LinearLayout
    private lateinit var llPagiPetangDzikir: LinearLayout
    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderDots: LinearLayout

    private lateinit var dotsIndicator: Array<ImageView?>
    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                dotsIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inective)
                )
            }

            dotsIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()

        setupViewPager()
    }

    private fun setupViewPager() {
        dotsIndicator = arrayOfNulls(listArtikel.size)
        for (i in 0 until listArtikel.size) {
            dotsIndicator[i] = ImageView(this)
            dotsIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_inective)
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            params.gravity = Gravity.CENTER_VERTICAL
            sliderDots.addView(dotsIndicator[i], params)
        }

        dotsIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
        )
    }

    private fun initView() {
        llQauliyahShalat = findViewById(R.id.ll_Qauliyah_Shalat)
        llSetiapSaatDzikir = findViewById(R.id.ll_Setiap_Saat_Dzikir)
        llHarianDzikirDoa = findViewById(R.id.ll_Harian_Dzikir_Doa)
        llPagiPetangDzikir = findViewById(R.id.ll_Pagi_Petang_Dzikir)

        llQauliyahShalat.setOnClickListener(this)
        llSetiapSaatDzikir.setOnClickListener(this)
        llHarianDzikirDoa.setOnClickListener(this)
        llPagiPetangDzikir.setOnClickListener(this)

        vpArtikel = findViewById(R.id.vp_artikel)
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        sliderDots = findViewById(R.id.ll_slider_dots)
    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.title_artikel)
        val descArtikel = resources.getStringArray(R.array.desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.img_artikel)

        listArtikel.clear()
        for (data in titleArtikel.indices) {
            val artikel = Artikel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    override fun onClick(view: View?) {
        /*if (view?.id == R.id.ll_Qauliyah_Shalat){
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }else if (view?.id == R.id.ll_Setiap_Saat_Dzikir){
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }else if (view?.id == R.id.ll_Harian_Dzikir_Doa){
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }else if (view?.id == R.id.ll_Pagi_Petang_Dzikir){
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }else{

        }*/

        when (view?.id) {
            R.id.ll_Qauliyah_Shalat -> startActivity(
                Intent(
                    this,
                    QauliyahShalatActivity::class.java
                )
            )
            R.id.ll_Setiap_Saat_Dzikir -> startActivity(
                Intent(
                    this,
                    SetiapSaatDzikirActivity::class.java
                )
            )
            R.id.ll_Harian_Dzikir_Doa -> startActivity(
                Intent(
                    this,
                    HarianDzikirDoaActivity::class.java
                )
            )
            R.id.ll_Pagi_Petang_Dzikir -> startActivity(
                Intent(
                    this,
                    PagiPetangDzikirActivity::class.java
                )
            )
        }
    }
}
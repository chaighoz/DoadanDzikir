package com.example.doadandzikir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dzikirapp.DataDzikirDoa

class QauliyahShalatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qauliyah_shalat)

        val rvQauliyahShalat = findViewById<RecyclerView>(R.id.rv_qauliyah_shalat )
        rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
        rvQauliyahShalat.adapter = DzikirDoaAdapter(DataDzikirDoa.listQauliyahShalat)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
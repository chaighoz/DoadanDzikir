package com.example.doadandzikir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dzikirapp.DataDzikirDoa

class DzikirPetangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_petang)

        val rvDzikirPetang = findViewById<RecyclerView>(R.id.rv_dzikir_petang)
        rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        rvDzikirPetang.adapter = DzikirDoaAdapter(DataDzikirDoa.listDzikirPetang)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
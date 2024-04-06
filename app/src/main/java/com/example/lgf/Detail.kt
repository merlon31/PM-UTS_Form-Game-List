package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar : ImageView = findViewById(R.id.ivgambar)
        val nama : TextView = findViewById(R.id.tvname)
        val rilis : TextView = findViewById(R.id.tvrilis)
        val deskripsi : TextView = findViewById(R.id.tvDeskripsi)

        val bundle : Bundle? = intent.extras
        val bnama = bundle!!.getString("idnama")
        val bgambar = bundle.getInt("idgambar")
        val brilis = bundle.getString("idrilis")
        val bdeskripsi = bundle.getString("iddeskripsi")

        gambar.setImageResource(bgambar)
        nama.text = bnama
        rilis.text = brilis
        deskripsi.text = bdeskripsi
    }
}
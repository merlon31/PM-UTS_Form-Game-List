package com.example.lgf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    private lateinit var gameRecyclerView : RecyclerView
    private lateinit var gambar : Array<Int>
    private lateinit var nama : Array<String>
    private lateinit var rilis : Array<String>
    private lateinit var deskripsi : Array<String>
    private lateinit var Gamelist : ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gambar = arrayOf(
            R.drawable.coc,
            R.drawable.gi,
            R.drawable.minecraft,
            R.drawable.ml,
            R.drawable.pubg,
            R.drawable.pz,
            R.drawable.sg,
            R.drawable.ss
        )

        nama = arrayOf(
            "Clash Of Clans",
            "Genshin Impact",
            "Mincecraft",
            "Mobile Legend",
            "Player Unknown Battleground",
            "Plant Vs Zombie",
            "Stumble Guys",
            "Subway Surfers"
        )
         rilis = arrayOf(
             "02 Agustus 2012",
             "28 September 2020",
             "18 November 2011",
             "14 Juli 2016",
             "18 Maret 2018",
             "05 Mei 2009",
             "07 Oktober 2021",
             "24 Mei 2012"
         )

        deskripsi = arrayOf(
            getString(R.string.coc),
            getString(R.string.gi),
            getString(R.string.mine),
            getString(R.string.ml),
            getString(R.string.pubg),
            getString(R.string.pvz),
            getString(R.string.sg),
            getString(R.string.ss)
        )

        gameRecyclerView = findViewById(R.id.gameRV)
        gameRecyclerView.layoutManager = LinearLayoutManager(this)
        gameRecyclerView.setHasFixedSize(true)

        Gamelist = arrayListOf<ItemData>()
        getDataUser()
    }
    private fun getDataUser(){
        for (i in gambar.indices){
            val dataGame = ItemData(gambar[i],nama[i],rilis[i])
            Gamelist.add(dataGame)
        }

        var adapter = MyAdapter(Gamelist)
        gameRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                intent = Intent(this@Home, Detail::class.java)
                intent.putExtra("idgambar",Gamelist[position].gambar)
                intent.putExtra("idnama",Gamelist[position].nama)
                intent.putExtra("idrilis",Gamelist[position].rilis)
                intent.putExtra("iddeskripsi",deskripsi[position])

                startActivity(intent)
            }
        })
    }
}
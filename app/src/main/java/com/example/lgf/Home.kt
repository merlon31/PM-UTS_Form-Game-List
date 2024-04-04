package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    private lateinit var gameRecyclerView : RecyclerView
    private lateinit var adapterGame : MyAdapter
    private lateinit var Gamelist : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gameRecyclerView = findViewById(R.id.gameRV)
        Gamelist = ArrayList()

        Gamelist.add(ItemData(R.drawable.coc, "Clash Of Clans", "2 Agustus 2012"))
        Gamelist.add(ItemData(R.drawable.gi, "Genshin Impact", "28 September 2020"))
        Gamelist.add(ItemData(R.drawable.minecraft, "Minecraft", "18 November 2011"))
        Gamelist.add(ItemData(R.drawable.ml, "Mobile Legend", "14 Juli 2016"))
        Gamelist.add(ItemData(R.drawable.pubg, "Player Unknow Battle Ground", "18 Maret 2018"))
        Gamelist.add(ItemData(R.drawable.pz, "Plaint VS Zombie", "5 Mei 2009"))
        Gamelist.add(ItemData(R.drawable.sg, "Stumble Guy", "7 Oktober 2021"))
        Gamelist.add(ItemData(R.drawable.ss, "Subway Surfers", "24 Mei 2012"))


        gameRecyclerView.layoutManager = LinearLayoutManager(this)
        gameRecyclerView.setHasFixedSize(true)
        adapterGame = MyAdapter(Gamelist)
        gameRecyclerView.adapter = adapterGame

    }
}
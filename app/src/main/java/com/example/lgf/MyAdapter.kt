package com.example.lgf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val namaList : ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder (ItemData : View) : RecyclerView.ViewHolder (ItemData) {
        val gambar : ImageView = ItemData.findViewById(R.id.Iv_Game)
        val nama   : TextView = ItemData.findViewById(R.id.idGame)
        val rilis : TextView = ItemData.findViewById(R.id.idRilis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val ItemData = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return MyViewHolder(ItemData)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.rilis.text = currentItem.rilis
    }

    override fun getItemCount(): Int = namaList.size

}
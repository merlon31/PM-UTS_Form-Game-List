package com.example.lgf

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val namaList : ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder (ItemData : View, listener: onItemClickListener) : RecyclerView.ViewHolder(ItemData) {
        val gambar : ImageView = ItemData.findViewById(R.id.Iv_Game)
        val nama   : TextView = ItemData.findViewById(R.id.idGame)
        val rilis : TextView = ItemData.findViewById(R.id.idRilis)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val ItemData = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return MyViewHolder(ItemData, mListener)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.rilis.text = currentItem.rilis
    }

    override fun getItemCount(): Int = namaList.size

}
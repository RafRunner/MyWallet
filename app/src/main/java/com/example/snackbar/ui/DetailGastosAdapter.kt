package com.example.snackbar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto

class DetailGastosAdapter(private val listGastos: MutableList<Gasto>) : RecyclerView.Adapter<DetailGastosAdapter.DetailGastosViewHolder>() {

    class DetailGastosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDescricao: TextView = view.findViewById(R.id.tvDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGastosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return DetailGastosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailGastosViewHolder, position: Int) {
        val currentItem = listGastos[position]
        holder.tvDescricao.text = currentItem.descricao
    }

    override fun getItemCount(): Int = listGastos.size
}
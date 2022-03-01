package com.example.notes.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.entities.Notes
import kotlinx.android.synthetic.main.item_home.view.*

class NotesAdapter(private val arrList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvTitle.text = arrList[position].title
        holder.itemView.tv_sub.text = arrList[position].subTitle
        holder.itemView.tv_item_data.text = arrList[position].dataTime
        holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))

    }

    override fun getItemCount() = arrList.size
}
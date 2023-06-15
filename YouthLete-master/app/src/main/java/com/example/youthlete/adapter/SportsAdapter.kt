package com.example.youthlete.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youthlete.R
import com.example.youthlete.model.Sports

class SportsAdapter(
    private var sportsList: List<Sports>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(sports: Sports)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        private val kursusTextView: TextView = itemView.findViewById(R.id.tv_item_kursus)
        private val imageView: ImageView = itemView.findViewById(R.id.iv_item_photo)

        fun bind(sports: Sports) {
            nameTextView.text = sports.name
            kursusTextView.text = sports.kursus
            Glide.with(itemView.context)
                .load(sports.imageResId)
                .into(imageView)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(sports)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sports = sportsList[position]
        holder.bind(sports)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    fun updateList(newList: List<Sports>) {
        sportsList = newList
        notifyDataSetChanged()
    }
}
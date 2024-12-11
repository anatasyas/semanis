package com.example.simanisapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simanisapp.R


class ArtikelAdapter(

    private val titles: Array<String>,
    private val descriptions: Array<String>,
    private val imageResIds: IntArray,
    private val links: Array<String>,
    private val itemClickListener: OnItemClickListener

) : RecyclerView.Adapter<ArtikelAdapter.ListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(link: String)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val title = titles[position]
        val description = descriptions[position]
        val imageResId = imageResIds[position]
        val link = links[position]

         Glide.with(holder.itemView.context)
            .load(imageResId)
            .into(holder.imgPhoto)

        holder.tvName.text = title
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(link)
        }
    }

    override fun getItemCount(): Int = titles.size
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imageArticle)
        val tvName: TextView = itemView.findViewById(R.id.judul_article)
        val tvDescription: TextView = itemView.findViewById(R.id.deskripsi_article)
    }
}

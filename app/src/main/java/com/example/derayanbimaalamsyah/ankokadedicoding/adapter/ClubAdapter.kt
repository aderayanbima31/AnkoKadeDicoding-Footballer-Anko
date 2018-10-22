package com.example.derayanbimaalamsyah.ankokadedicoding.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.derayanbimaalamsyah.ankokadedicoding.DetailActivity
import com.example.derayanbimaalamsyah.ankokadedicoding.R
import com.example.derayanbimaalamsyah.ankokadedicoding.R.layout.item_list
import com.example.derayanbimaalamsyah.ankokadedicoding.model.ClubModel
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.util.*

class ClubAdapter(private val context: Context, private val items: List<ClubModel>)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val name: TextView = view.find(R.id.name)
        val image: ImageView = view.find(R.id.image)

        fun bindItem(items: ClubModel) {
            name.text = items.name
            Glide.with(itemView).load(items.image).into(image)
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>(DetailActivity.JUDUL to  items.name, DetailActivity.GAMBAR to items.image, DetailActivity.DESKRIPSI to items.description)
            }
        }

    }




}
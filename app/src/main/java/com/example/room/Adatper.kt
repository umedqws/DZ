package com.example.room

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class Adatper:ListAdapter<Pizza,Adatper.RecycleViewHolder>(RcDiffUtils()) {
    var onClick: ((Pizza)->Unit)? = null
   inner class RecycleViewHolder(itemView:View):ViewHolder(itemView){
      init {
          itemView.setOnClickListener {
              onClick?.invoke(getItem(adapterPosition))
          }
      }

       init {
           var doubleClick: Boolean? = false
           itemView.setOnClickListener {
               if (doubleClick!!) {
                   onClick?.invoke(getItem(adapterPosition))
               }
               doubleClick = true
               Handler().postDelayed({ doubleClick = false }, 2000)
           }
       }

        fun bind(pizza: Pizza){
            val name = itemView.findViewById<TextView>(R.id.name)
            val price = itemView.findViewById<TextView>(R.id.price)
            val imageView = itemView.findViewById<ImageView>(R.id.image_view)
            name.text = pizza.name
            price.text = pizza.price.toString()
            Glide
                .with(itemView.context)
                .load(pizza.imageURL)
                .into(imageView)
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_bd,parent,false))
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class RcDiffUtils:DiffUtil.ItemCallback<Pizza>(){
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem == newItem
    }
}
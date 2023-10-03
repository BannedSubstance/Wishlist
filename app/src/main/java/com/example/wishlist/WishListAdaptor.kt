package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdaptor(private val wishItems: List<WishItem>) : RecyclerView.Adapter<WishListAdaptor.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val storeTextView: TextView
        val priceTextView: TextView
        init {
            nameTextView = itemView.findViewById(R.id.nameTv)
            storeTextView = itemView.findViewById(R.id.storeTv)
            priceTextView = itemView.findViewById(R.id.priceTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return wishItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = wishItems[position]
        // Set item views based on views and data model
        holder.nameTextView.text = email.name
        holder.storeTextView.text = email.store
        holder.priceTextView.text = email.price
    }
}
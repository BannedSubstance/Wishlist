package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var wishItems: List<WishItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wishList = findViewById<RecyclerView>(R.id.itemList)
        val button = findViewById<Button>(R.id.button)
        val inputName = findViewById<EditText>(R.id.itemName)
        val inputPrice = findViewById<EditText>(R.id.priceEdit)
        val inputStore = findViewById<EditText>(R.id.url)
        wishItems = WishData.getWishes()
        button.setOnClickListener {
            val adaptor = WishListAdaptor(wishItems)
            val price = inputPrice.text.toString()
            WishData.insertWish(inputName.text.toString(), inputStore.text.toString(), price.toDouble())
            wishList.adapter = adaptor
            wishList.layoutManager = LinearLayoutManager(this)
            adaptor.notifyDataSetChanged()
            inputName.text.clear()
            inputPrice.text.clear()
            inputStore.text.clear()
        }
    }
}
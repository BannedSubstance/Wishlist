package com.example.wishlist

class WishData {
    companion object {
        private var wishList: MutableList<WishItem> = ArrayList()

        fun insertWish(name: String, url: String, price: Double) {
            wishList.add(WishItem(name, url, String.format("$%.2f", price)))
        }

        fun getWishes(): List<WishItem> {
            return wishList
        }
    }
}
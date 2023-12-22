package com.bitcodetech.machinetest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("select _id, title, price from products")
    fun getProducts() : List<Product>

    @Insert
    fun insert(product: Product)

}
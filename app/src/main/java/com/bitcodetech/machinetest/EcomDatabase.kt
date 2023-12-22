package com.bitcodetech.machinetest

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(version = 1, entities = [Product::class])
abstract class EcomDatabase:RoomDatabase(){
    abstract fun getProductDao() : ProductDao
}
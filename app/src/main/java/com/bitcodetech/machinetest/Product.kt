package com.bitcodetech.machinetest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class Product (
     @PrimaryKey
     @ColumnInfo(name = "_id")
     val id : Int,
     val title : String,
     val price : Int = 0
 )

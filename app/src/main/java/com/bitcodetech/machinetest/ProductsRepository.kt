package com.bitcodetech.machinetest

class ProductsRepository (
    private val productDao:ProductDao
){
    suspend fun getProducts():List<Product>{
        return productDao.getProducts()
    }
    suspend fun insert(product : Product) {
        return productDao.insert(product)
    }
}




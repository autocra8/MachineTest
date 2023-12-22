package com.bitcodetech.machinetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    val productUpdateAvailableLiveData = MutableLiveData<Boolean>()

    val products = ArrayList<Product>()

    fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            val products = productsRepository.getProducts()

            withContext(Dispatchers.Main) {
                this@ProductViewModel.products.addAll(products)
                productUpdateAvailableLiveData.postValue(true)
            }
        }
    }
}


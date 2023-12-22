package com.bitcodetech.machinetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(
    private val productsRepository: ProductsRepository
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productsRepository) as T
    }
}
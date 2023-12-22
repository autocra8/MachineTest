package com.bitcodetech.machinetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductsFragment : Fragment() {
    private lateinit var btnAddUser: FloatingActionButton
    private lateinit var recyclerProducts: RecyclerView
    private lateinit var productsViewModel: ProductViewModel
    private lateinit var ecomDatabase: EcomDatabase
    private lateinit var productsAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.users_fragment, null)

        initDatabase()
        initViews(view)
        initViewModels()
        initAdapter()
        initObservers()

        //initData()
        productsViewModel.getProducts()

        return view
    }

    private fun initData() {
        ecomDatabase.getProductDao().insert(Product(1, "AA", 123))
        ecomDatabase.getProductDao().insert(Product(2, "AA", 123))
        ecomDatabase.getProductDao().insert(Product(3, "AA", 123))
    }

    private fun initAdapter() {
        recyclerProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        productsAdapter = ProductAdapter(productsViewModel.products)
        recyclerProducts.adapter = productsAdapter
    }

    private fun initObservers() {
        productsViewModel.productUpdateAvailableLiveData.observe(
            viewLifecycleOwner
        ) {
            if (it) {
                productsAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initDatabase() {
        ecomDatabase = Room.databaseBuilder(
            requireContext(),
            EcomDatabase::class.java,
            "db_ecomm"
        ).allowMainThreadQueries()
            .build()

    }

    private fun initViews(view: View) {
        btnAddUser = view.findViewById(R.id.btnAddUser)
        recyclerProducts = view.findViewById(R.id.recyclerUsers)
        recyclerProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initViewModels() {
        productsViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(
                ProductsRepository(
                    ecomDatabase.getProductDao()
                )
            )
        ).get(ProductViewModel::class.java)
    }
}

package com.bitcodetech.machinetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (
    private val product:ArrayList<Product>
):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){



    inner class ProductViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtProductName:TextView
        val txtProductId:TextView
        val txtProductPrice:TextView

        init {
            txtProductId=view.findViewById(R.id.txtProductId)
            txtProductName=view.findViewById(R.id.txtProductName)
            txtProductPrice=view.findViewById(R.id.txtProductPrice)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_view, null)
        )
    }

    override fun getItemCount()=product.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = product[position]
        holder.txtProductId.text = product.id.toString()
        holder.txtProductName.text = product.title
        holder.txtProductPrice.text=product.price.toString()
    }
}
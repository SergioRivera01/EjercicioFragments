package com.sergiorivera.ejerciciofragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sergiorivera.ejerciciofragments.databinding.ItemProductBinding
import com.sergiorivera.ejerciciofragments.model.Product




class ProductAdapter(private val onUserClicked: (Product) -> Unit): ListAdapter<Product, ProductAdapter.viewHolder>(ProductItemCallBack()) {

    inner class viewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProductBinding = ItemProductBinding.inflate(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val product = getItem(position)

        holder.binding.tvName.text = product.nombre
        holder.binding.tvPrice.text = product.precio.toString() + "€"
        holder.binding.ivProduct.setImageResource(product.imagen)

        if(product.stock < 5){
            holder.binding.tvStock.text = "HAY MENOS DE 5 UNIDADES"

        }else{
            holder.binding.tvStock.visibility = View.GONE

        }


        holder.binding.root.setOnClickListener{
            onUserClicked(product)
        }
    }
}

class ProductItemCallBack: DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.id == newItem.id

}
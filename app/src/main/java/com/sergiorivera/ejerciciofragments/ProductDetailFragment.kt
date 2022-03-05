package com.sergiorivera.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.sergiorivera.ejerciciofragments.databinding.FragmentProductDetailBinding
import com.sergiorivera.ejerciciofragments.model.Product

interface onUserDetail{
    fun onClick(producto: Product)
}

class UserDetailFragment : Fragment() {


    private var _binding : FragmentProductDetailBinding? = null
    private val binding
        get() = _binding!!

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val producto : Product = products[args.id]
        binding.tvNameD.text = producto.nombre
        binding.tvPriceD.text = producto.precio.toString()
        if (producto.disponible == false){
            binding.tvAvalibleD.text = "No"
        }else if(producto.disponible == true){
            binding.tvAvalibleD.visibility = View.GONE
            binding.tvLabelAvalible.visibility = View.GONE
        }
        binding.tvStockD.text = producto.stock.toString()
        binding.ivProductD.setImageResource(producto.imagen)
        binding.tvDescriptionD.text = producto.descripcion

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.sergiorivera.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sergiorivera.ejerciciofragments.databinding.FragmentProductListBinding
import com.sergiorivera.ejerciciofragments.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: ProductAdapter = ProductAdapter (::onUserClicked)

    private fun onUserClicked(product: Product) {
        val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(product.id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUsers.layoutManager = GridLayoutManager(context, 2)
        binding.rvUsers.adapter = adapter

        adapter.submitList(products)

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}



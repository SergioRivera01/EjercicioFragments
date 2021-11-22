package com.sergiorivera.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.sergiorivera.ejerciciofragments.databinding.FragmentUserListBinding
class UserDetailFragment : Fragment() {

    private var _binding : FragmentUserListBinding? = null
    private val binding
        get() = _binding!!

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "UserId: ${args.userId}", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
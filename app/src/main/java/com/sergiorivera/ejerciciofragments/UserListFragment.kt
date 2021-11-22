package com.sergiorivera.ejerciciofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sergiorivera.ejerciciofragments.databinding.FragmentUserListBinding
import com.sergiorivera.ejerciciofragments.model.User


class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: UserAdapter = UserAdapter(object : onUserListener {
        override fun onClick(user: User) {
            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(user.id)
            findNavController().navigate(action)
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUsers.layoutManager = GridLayoutManager(context, 2)
        binding.rvUsers.adapter = adapter

        val users: List<User> = List(5) { User("$it", "Name $it", "Country $it", "h") }
        adapter.submitList(users)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


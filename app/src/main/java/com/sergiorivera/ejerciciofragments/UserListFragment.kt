package com.sergiorivera.ejerciciofragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sergiorivera.ejerciciofragments.databinding.FragmentUserListBinding
import com.sergiorivera.ejerciciofragments.model.User
import com.sergiorivera.ejerciciofragments.model.UserResponse
import com.sergiorivera.ejerciciofragments.network.RandomUserService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

//baseURL = https://randomuser.me/api/
class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: UserAdapter = UserAdapter {
        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(it.id)
        findNavController().navigate(action)
    }

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

        requestData()

        val users: List<User> = List(50) { User("$it", "Name $it", "Country $it", "h") }
        adapter.submitList(users)

    }

    private fun requestData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: RandomUserService = retrofit.create(RandomUserService::class.java)

       // service.getUsers().enqueue(object : Callback<UserResponse> {
       //    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
       //            Log.d("retrofit", "bien")
       //    }
       //
       //     override fun onFailure(call: Call<List<User>>, t: Throwable) {
       //         Log.v("retrofit", "call failed")
       //     }
       // })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}



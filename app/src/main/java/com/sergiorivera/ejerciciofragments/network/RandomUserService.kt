package com.sergiorivera.ejerciciofragments.network



import com.sergiorivera.ejerciciofragments.model.User
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserService {
    @GET("?results=50")
    fun getUsers(): Call<List<User>>
}
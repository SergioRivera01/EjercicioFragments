package com.sergiorivera.ejerciciofragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sergiorivera.ejerciciofragments.databinding.ItemUserBinding
import com.sergiorivera.ejerciciofragments.model.User
import com.squareup.picasso.Picasso


interface onUserListener{
    fun onClick(user : User)
}
class UserAdapter(private val listener : onUserListener): ListAdapter<User, UserAdapter.viewHolder>(UserItemCallBack()) {

    inner class viewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemUserBinding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val user = getItem(position)

        holder.binding.tvName.text = user.name
        holder.binding.tvCountry.text = user.country
        Picasso.get().load(user.imageUrl).placeholder(R.drawable.ic_launcher_foreground).into(holder.binding.ivAvatar)

        holder.binding.root.setOnClickListener{
            listener.onClick(user)
        }
    }
}

class UserItemCallBack: DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

}
package com.example.recyclerviewwsr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewwsr.databinding.ItemUserBinding
import com.example.recyclerviewwsr.model.User

class UserAdapter(input: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(), View.OnClickListener {

    private var users: List<User> = input


    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.itemView.tag = user
        with(holder.binding){
            tvUserName.text = user.name
            tvUserCompany.text = user.company
            Glide
                .with(imgvUserImage.context)
                .load(user.photo)
                .circleCrop()
                .into(imgvUserImage)
        }
    }

    override fun getItemCount(): Int = users.size

    override fun onClick(v: View) {
        val user = v.tag as User
        Toast.makeText(v.context, user.toString(), Toast.LENGTH_SHORT).show()
    }
}
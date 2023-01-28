package com.example.appuserroom.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appuserroom.databinding.RowUserBinding
import com.example.appuserroom.service.model.UserModel
import com.example.appuserroom.view.viewholder.UserViewHolder

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var listUsers: List<UserModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }

    override fun getItemCount(): Int {
        return listUsers.count()
    }

    fun updateUsers(list: List<UserModel>) {
        listUsers = list
        notifyDataSetChanged()
    }
}
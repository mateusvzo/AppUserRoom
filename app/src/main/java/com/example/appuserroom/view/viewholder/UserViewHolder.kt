package com.example.appuserroom.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.appuserroom.databinding.RowUserBinding
import com.example.appuserroom.service.model.UserModel

class UserViewHolder(private val bind: RowUserBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(user: UserModel) {
        bind.textName.text = user.name
    }
}
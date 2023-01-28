package com.example.appuserroom.service.repository

import android.content.Context
import com.example.appuserroom.service.database.UserDataBase
import com.example.appuserroom.service.model.UserModel

class UserRepository(context: Context) {

    private val userDataBase = UserDataBase.getDataBase(context).userDAO()

    fun save(user: UserModel): Boolean {
        return userDataBase.insert(user) > 0
    }

    fun update(user: UserModel): Boolean {
        return userDataBase.update(user) > 0
    }

    fun get() : List<UserModel> {
        return userDataBase.get()
    }

    fun delete(user: UserModel) {
        userDataBase.delete(user)
    }
}
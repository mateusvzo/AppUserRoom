package com.example.appuserroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appuserroom.service.model.UserModel
import com.example.appuserroom.service.repository.UserRepository

class CreateUserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = UserRepository(application.applicationContext)

    private var _saveUser = MutableLiveData<Boolean>()
    val saveUser: LiveData<Boolean> = _saveUser

//    private var _user = MutableLiveData<UserModel>()
//    val user: LiveData<UserModel> = _user

    fun save(id: Int, name: String, gender: Boolean) {
        val user = UserModel().apply {
            this.id = id
            this.name = name
            this.gender = gender
        }
        _saveUser.value = repository.save(user)
    }

    fun getUsers(): List<UserModel> {
        return repository.get()
    }

    fun delete(user: UserModel) {
        repository.delete(user)
    }

}
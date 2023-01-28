package com.example.appuserroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appuserroom.service.model.UserModel
import com.example.appuserroom.service.repository.UserRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = UserRepository(application.applicationContext)

    private val _allUser = MutableLiveData<List<UserModel>>()
    val allUser: LiveData<List<UserModel>> = _allUser

    fun getAllUser() {
        _allUser.value = repository.get()
    }



}
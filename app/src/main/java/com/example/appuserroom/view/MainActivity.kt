package com.example.appuserroom.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appuserroom.databinding.ActivityMainBinding
import com.example.appuserroom.view.adapter.UserAdapter
import com.example.appuserroom.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding.root)

        //Layout
        binding.recyclerUser.layoutManager = LinearLayoutManager(applicationContext)

        //Adapter
        binding.recyclerUser.adapter = adapter

        observe()

        binding.buttonAdd.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllUser()
    }

    override fun onClick(v: View) {
        if(v.id == binding.buttonAdd.id) {
            startActivity(Intent(this, CreateUser::class.java))
        }
    }

    private fun observe() {
        viewModel.allUser.observe(this, Observer {
            adapter.updateUsers(it)
        })
    }
}
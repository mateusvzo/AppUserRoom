package com.example.appuserroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appuserroom.viewmodel.CreateUserViewModel
import com.example.appuserroom.databinding.ActivityCreateUserBinding

class CreateUser : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateUserBinding
    private lateinit var viewModel: CreateUserViewModel
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        observe()
    }

    override fun onClick(v: View) {
        if(v.id == binding.buttonSave.id) {
            val name = binding.editName.text.toString()
            val gender = binding.radioMasculine.isChecked

            viewModel.save(userId, name, gender)
            finish()
        }
    }

    private fun observe() {
        viewModel.saveUser.observe(this, Observer {
            if(it) {
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
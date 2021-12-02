package com.example.recyclerviewwsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewwsr.adapter.UserAdapter
import com.example.recyclerviewwsr.databinding.ActivityMainBinding
import com.example.recyclerviewwsr.utils.Service

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var service: Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = Service()
        userAdapter = UserAdapter(service.getUsers())
        binding.rvUsers.adapter = userAdapter

    }
}
package com.mufidz.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_user)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerlist()
    }

    private val listUser: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataRepo = resources.getStringArray(R.array.repository)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<User>()
            for (i in dataName.indices){
                val user = User(dataName[i], "@" + dataUsername[i], dataRepo[i] + " Repositories", dataPhoto.getResourceId(i,-1))
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerlist() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(list)
        rvUsers.adapter = listUserAdapter
    }
}
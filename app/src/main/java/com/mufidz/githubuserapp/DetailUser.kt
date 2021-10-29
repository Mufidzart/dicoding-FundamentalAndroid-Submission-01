package com.mufidz.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class DetailUser : AppCompatActivity() {
    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val imgPhoto:ImageView = findViewById(R.id.img_user_detail)
        val tvNama:TextView = findViewById(R.id.tv_name_detail)
        val tvUsername:TextView = findViewById(R.id.tv_username_detail)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        tvNama.text = user.name
        tvUsername.text = user.username
        imgPhoto.setImageResource(user.photo)
    }
}
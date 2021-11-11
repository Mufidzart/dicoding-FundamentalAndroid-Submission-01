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
        val tvCompany:TextView = findViewById(R.id.tv_company_detail)
        val tvLocation:TextView = findViewById(R.id.tv_location)
//        val tvRepository:TextView = findViewById(R.id.tv_count_repository)
//        val tvFollower:TextView = findViewById(R.id.tv_count_follower)
//        val tvFollowing:TextView = findViewById(R.id.tv_count_following)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        tvNama.text = user.name
        tvCompany.text = user.company
        tvLocation.text = user.location
//        tvRepository.text = user.repo
//        tvFollower.text = user.follower
//        tvFollowing.text = user.following
        imgPhoto.setImageResource(user.photo)
    }
}
package com.mufidz.githubuserapp

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, repo,rate, photo) = listUser[position]
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.tvRepo.text = repo
        holder.nRate.setRating(rate)
        holder.imgPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener{
            val user = User(
                name, username, repo, rate, photo
            )
            val intent = Intent(it.context, DetailUser::class.java)
            intent.putExtra(DetailUser.EXTRA_USER, user)
            it.context.startActivity(intent)
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listUser[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = (listUser.size)

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_user)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvRepo: TextView = itemView.findViewById(R.id.tv_repo)
        var nRate: RatingBar = itemView.findViewById(R.id.rtb_user)

    }

}
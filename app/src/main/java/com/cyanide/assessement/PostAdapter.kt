package com.cyanide.assessement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.cyanide.assessement.databinding.ActivityPostBinding


class PostAdapter(var postList: List<Posts>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding= ActivityPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postList[position]
        val binding = holder.binding

        binding.tvtitle.text = currentPost.title
        binding.tvuserid.text = currentPost.userid.toString()
        binding.tvbody.text =currentPost.body



    }

    override fun getItemCount(): Int {
        return  postList.size
    }

}

class PostViewHolder(var binding: ActivityPostBinding): RecyclerView.ViewHolder(binding.root){

}
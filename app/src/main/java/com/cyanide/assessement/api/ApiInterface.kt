package com.cyanide.assessement.api

import com.cyanide.assessement.PostResponse
import com.cyanide.assessement.Posts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<PostResponse>
}
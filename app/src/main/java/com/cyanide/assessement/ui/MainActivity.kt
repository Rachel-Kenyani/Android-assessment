package com.cyanide.assessement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cyanide.assessement.PostAdapter
import com.cyanide.assessement.PostResponse
import com.cyanide.assessement.R
import com.cyanide.assessement.api.ApiClient
import com.cyanide.assessement.api.ApiInterface
import com.cyanide.assessement.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        fetchPost()
    }
    fun fetchPost() {
        val apiClient = ApiClient.buildClient(ApiInterface::class.java)
        val request = apiClient.getPosts()

        request.enqueue(object : Callback<PostResponse> {
            override fun onResponse(
                call: Call<PostResponse>,
                response: Response<PostResponse>
            ) {
                if (response.isSuccessful) {
                    val posts = response.body()?.posts
                    val rvAdapter = PostAdapter(posts ?: emptyList())

                    // Set the adapter to RecyclerView only when it's available
                    binding.rvposts.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvposts.adapter = rvAdapter

                    // Move this Toast message outside the adapter setup
                    Toast.makeText(baseContext, "Fetched ${posts?.size} posts", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }


}




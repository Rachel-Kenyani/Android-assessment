package com.cyanide.assessement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cyanide.assessement.PostAdapter
import com.cyanide.assessement.PostResponse
import com.cyanide.assessement.R
import com.cyanide.assessement.api.ApiClient
import com.cyanide.assessement.api.ApiInterface
import com.cyanide.assessement.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding=ActivityPostBinding.inflate(layoutInflater)
    }

}
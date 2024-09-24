package com.partha.clickretina.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.partha.clickretina.R
import com.partha.clickretina.databinding.ActivityMainBinding
import com.partha.clickretina.pojoClasses.ContentResponse
import com.partha.clickretina.pojoClasses.Response
import com.partha.clickretina.retrofit.RetrofitRepository
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var contentResponse: ContentResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        fetchResponse()



    }

    private fun init() {
        binding.titleValueTV.text = contentResponse?.titles?.get(0) ?: "This is the title generated"
        binding.descriptionValueTV.text = contentResponse?.description
    }

    private fun fetchResponse() {
        binding.progressBar.isVisible = true
        RetrofitRepository.getResponse().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                response.body()?.choices?.get(0)?.message?.content?.let {
                    binding.progressBar.isVisible = false
                    val gson = Gson()
                    contentResponse = gson.fromJson(it, ContentResponse::class.java)
                    init()
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                binding.progressBar.isVisible = false
                t.printStackTrace()
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
package com.choota.myapplication.services.api.blog

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.choota.myapplication.services.api.RestApiService
import com.choota.myapplication.services.api.blog.model.Blog
import com.choota.myapplication.services.api.blog.model.BlogResponse
import com.choota.myapplication.services.api.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class BlogRepository(application: Application) {
    private val blogs = MutableLiveData<List<Blog>?>()

    fun blogsList(): MutableLiveData<List<Blog>?> {
        ServiceGenerator.createService(RestApiService::class.java)
            .popularBlogList()
            .enqueue(object : Callback<BlogResponse> {

                override fun onResponse(call: Call<BlogResponse>, response: Response<BlogResponse>) {
                    if (response.isSuccessful && response.body() != null && response.body()!!.blog != null){
                        blogs.value = response.body()!!.blog as ArrayList<Blog>
                    }
                }

                override fun onFailure(call: Call<BlogResponse>, t: Throwable) {}
            })

        return blogs
    }
}
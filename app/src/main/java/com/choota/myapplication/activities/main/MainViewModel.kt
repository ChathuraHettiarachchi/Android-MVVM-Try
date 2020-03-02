package com.choota.myapplication.activities.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.choota.myapplication.services.api.blog.BlogRepository
import com.choota.myapplication.services.api.blog.model.Blog

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var blogRepo: BlogRepository = BlogRepository(application)

    val allBlogs: MutableLiveData<List<Blog>?> get() = blogRepo.blogsList()
}
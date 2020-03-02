package com.choota.myapplication.services.api.blog.model

import com.choota.myapplication.services.api.blog.model.Blog
import com.google.gson.annotations.SerializedName

class BlogResponse {
    @SerializedName("data")
    var blog: List<Blog>? = null
    @SerializedName("error")
    var error: Boolean? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("status")
    var status: String? = null

}
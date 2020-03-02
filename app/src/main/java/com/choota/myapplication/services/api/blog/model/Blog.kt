package com.choota.myapplication.services.api.blog.model

import com.google.gson.annotations.SerializedName

class Blog {
    @SerializedName("author")
    var author: String = "Author"
    @SerializedName("description")
    var description: String = "Description"
    @SerializedName("link")
    var link: String = "Link"
    @SerializedName("pubDate")
    var pubDate: String = "Date"
    @SerializedName("thumbnail")
    var thumbnail: String = "Thumbnail"
    @SerializedName("title")
    var title: String = "Title"

}
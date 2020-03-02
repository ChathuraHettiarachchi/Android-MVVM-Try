package com.choota.myapplication.services.api;

import com.choota.myapplication.services.api.blog.model.BlogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("feed.json")
    Call<BlogResponse> popularBlogList();
}

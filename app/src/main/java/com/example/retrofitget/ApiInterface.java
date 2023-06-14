package com.example.retrofitget;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("posts/{id}")
    public Call<Post> GetPost(@Path("id") int postId);
    @GET("posts")
    public Call<List<Post>> GetPostByQuery(@Query("userId") String userId);

    @POST("posts")
    public Call<Post> UploadPost(@Body Post post);

    @POST("posts")
    public Call<Post> UploadPostWithHashMap(@Body HashMap<Object, Object> map);

}

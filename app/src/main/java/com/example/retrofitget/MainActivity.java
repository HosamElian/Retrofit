package com.example.retrofitget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView postTitleTv = findViewById(R.id.post_title_tv);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        Post post = new Post(5, "Hosam Post", "Hi, i am using retrofit");
//        Call<Post> call = apiInterface.UploadPost(post);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "Hossam Again");
        map.put("body", "Hi, i am using retrofit");
        map.put("userId", 9);

        Call<Post> call = apiInterface.UploadPostWithHashMap(map);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                postTitleTv.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postTitleTv.setText(t.getMessage());

            }
        });
//        Call<Post> call = apiInterface.GetPost(1);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                postTitleTv.setText(response.body().getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                postTitleTv.setText(t.getMessage());
//
//            }
//        });
//
//        Call<List<Post>> call = apiInterface.GetPostByQuery("1");
//
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                postTitleTv.setText(response.body().get(2).getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                postTitleTv.setText(t.getMessage());
//            }
//        });

    }
}
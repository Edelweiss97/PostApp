package com.example.postapp.data.remode;

import com.example.postapp.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {

    @GET("/posts")
    Call<List<Post>> getPost();

    @POST("/posts")
    Call<Post> createPost(
            @Body Post post
    );

    @GET("/posts/{id}")
    Call<Post> getPostById(
            @Path("id")
                    String id
    );

    @PUT("/posts/{id}")
    Call<Post> putPost(
            @Path("id")
                    int id,
            @Body Post post

    );
    @DELETE("/posts/{id}")
    Call<Post> delete(
            @Path("id")
    int id);
}

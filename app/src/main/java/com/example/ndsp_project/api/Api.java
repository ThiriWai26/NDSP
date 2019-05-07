package com.example.ndsp_project.api;


import com.example.ndsp_project.Response.AuthorDetailResponse;
import com.example.ndsp_project.Response.AuthorListResponse;
import com.example.ndsp_project.Response.GenreDetailResponse;
import com.example.ndsp_project.Response.GenreListResponse;
import com.example.ndsp_project.Response.PublisherDetailResponse;
import com.example.ndsp_project.Response.PublisherListResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("api/author/all")
    Call<AuthorListResponse> getAuthorList();

    @GET("api/publisher/all")
    Call<PublisherListResponse> getPublisherList();

    @GET("api/genre/all")
    Call<GenreListResponse> getGenreList();

    @GET("api/book/by_publisher/{publisher_id}")
    Call<PublisherDetailResponse> getPublisherDetail(@Path("publisher_id") String publisher_id);

    @GET("api/book/by_author/{author_id}")
    Call<AuthorDetailResponse> getAuthorDetail(@Path("author_id") String author_id);

    @GET("api/book/by_genre/{genre_id}")
    Call<GenreDetailResponse> getGenreDetail(@Path("genre_id") String genre_id);


}



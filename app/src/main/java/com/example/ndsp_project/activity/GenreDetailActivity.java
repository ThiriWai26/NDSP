package com.example.ndsp_project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.GenreDetailResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.GenreDetail;
import com.example.ndsp_project.model.PublisherDetail;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreDetailActivity extends AppCompatActivity {

    private RetrofitService service;
    private RecyclerView recyclerView;
    private String BookList;
    List<GenreDetail> genrecategories = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        initActivity();

    }

    private void initActivity() {

        service = new RetrofitService();
        recyclerView = findViewById(R.id.recyclerView);

        Bundle bundle = getIntent().getExtras();
        BookList = bundle.getString("book_id");
        Log.e("genre_id",BookList);

        getGenreDetail();
    }

    private void getGenreDetail() {

        Log.e("getgenreDetail","success");
        Api genreDetailApi = service.getRetrofitService().create(Api.class);
        genreDetailApi.getGenreDetail(BookList).enqueue(new Callback<GenreDetailResponse>() {
            @Override
            public void onResponse(Call<GenreDetailResponse> call, Response<GenreDetailResponse> response) {

                if(response.isSuccessful()){

                    genrecategories.addAll(response.body().genre);
                    Log.e("genreList",String.valueOf(response.body().genre));
                }
            }

            @Override
            public void onFailure(Call<GenreDetailResponse> call, Throwable t) {

            }
        });


    }
}

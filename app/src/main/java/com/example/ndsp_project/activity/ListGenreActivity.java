package com.example.ndsp_project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.GenreListResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.Genre;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListGenreActivity extends AppCompatActivity {

    private TextView genreid;
    List<Author> genrecategories = new ArrayList<>();
    private String BookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_genre);

        initActivity();

        Bundle bundle = getIntent().getExtras();
        BookList = bundle.getString("BookList");

//        genreid.setText(BookList);
        Log.e("booklist",BookList);


    }

    private void initActivity() {

        genreid = findViewById(R.id.genre_id);

    }

//    private void getGenreList() {
//
//        Log.e("getGenreList","success");
//        Api genreListApi = service.getRetrofitService().create(Api.class);
//        genreListApi.getGenreList().enqueue(new Callback<GenreListResponse>() {
//            @Override
//            public void onResponse(Call<GenreListResponse> call, Response<GenreListResponse> response) {
//
//                if(response.isSuccessful()){
//
//                    Genre genreDetail = response.body().genres.get(0);
//                    String GenreId = genreDetail.id;
//
//                    genreid.setText(GenreId);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GenreListResponse> call, Throwable t) {
//
//            }
//        });
//
//    }
}

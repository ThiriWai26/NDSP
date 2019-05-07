package com.example.ndsp_project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.GenreListResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Genre;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreActivity extends AppCompatActivity {
    private ListView GenreList;
    private RetrofitService service;

    List<Genre> genrecategories = new ArrayList<>();
    List<String> genres = new ArrayList<>();

    ArrayAdapter<String> dataadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        initGenreList();
    }

    private void initGenreList() {

        GenreList = findViewById(R.id.genre_List);

        service = new RetrofitService();

        getGenreList();

        dataadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,genres);

        GenreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String BookList = dataadapter.getItem(position);
                Log.e("genrecategoried", String.valueOf(genrecategories.get(position).id));
                Log.e("position", String.valueOf(position));

                Intent intent =new Intent(getApplicationContext(), GenreDetailActivity.class);
                intent.putExtra("BookList", genrecategories.get(position).id);
                Log.e("genreActicity_id",genrecategories.get(position).id);
                startActivity(intent);

            }
        });

    }

    private void getGenreList() {

        Api genreListApi = service.getRetrofitService().create(Api.class);
        genreListApi.getGenreList().enqueue(new Callback<GenreListResponse>() {
            @Override
            public void onResponse(Call<GenreListResponse> call, Response<GenreListResponse> response) {

                if (response.isSuccessful()){
                    genrecategories.addAll(response.body().genres);
                    Log.e("response",String.valueOf(response.body().genres.size()));
                    for(int i=0;i<genrecategories.size();i++){
                        genres.add(genrecategories.get(i).genrename);
                    }

                    dataadapter.notifyDataSetChanged();
                    GenreList.setAdapter(dataadapter);
                }

            }

            @Override
            public void onFailure(Call<GenreListResponse> call, Throwable t) {

            }
        });



    }
}

package com.example.ndsp_project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.AuthorDetailResponse;
import com.example.ndsp_project.adapter.AuthorAdapter;
import com.example.ndsp_project.adapter.PublisherAdapter;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.holder.AuthorHolder;
import com.example.ndsp_project.holder.publisherholders;
import com.example.ndsp_project.model.AuthorDetail;
import com.example.ndsp_project.model.PublisherDetail;
import com.example.ndsp_project.service.RetrofitService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorDetailActivity extends AppCompatActivity implements AuthorHolder.OnAuthorClickListener {

    private RetrofitService service;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private TextView tvtitle,tvname,tvprice;
    private ImageView imageView;
    private String BookList;

    List<AuthorDetail> authorcategories = new ArrayList<>();

    private AuthorAdapter adapter;

    List<AuthorDetail> authors = new ArrayList<>();
    List<AuthorDetail> newauthors = new ArrayList<>();
    private LinearLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        initActivity();

//        searchViewModify();
    }


    private void initActivity() {

        service = new RetrofitService();
        recyclerView = findViewById(R.id.recyclerView);
        tvtitle = findViewById(R.id.tvtitle);
        tvname = findViewById(R.id.tvname);
        tvprice = findViewById(R.id.tvprice);
        imageView = findViewById(R.id.profile);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
        BookList = bundle.getString("book_id");
        Log.e("author_id",BookList);

        adapter = new AuthorAdapter(this);

        getAuthorDetail();

    }

    private void getAuthorDetail() {

        Log.e("getauthorDetail","success");
        Api authorDetailApi = service.getRetrofitService().create(Api.class);
        authorDetailApi.getAuthorDetail(BookList).enqueue(new Callback<AuthorDetailResponse>() {
            @Override
            public void onResponse(Call<AuthorDetailResponse> call, Response<AuthorDetailResponse> response) {

                if(response.isSuccessful()){
                        //output authorsize
                    authorcategories.addAll(response.body().author);
                    Log.e("authorList", String.valueOf(response.body().author.size()));

                    adapter.addItem(response.body().author);
                    Log.e("authorList", String.valueOf(response.body().author.size()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<AuthorDetailResponse> call, Throwable t) {

            }
        });

    }

    public void onAuthorClick(int parseInt) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }




}

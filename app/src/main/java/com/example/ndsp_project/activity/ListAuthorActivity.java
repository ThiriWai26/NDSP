package com.example.ndsp_project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.AuthorDetailResponse;
import com.example.ndsp_project.Response.AuthorListResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.AuthorDetail;
import com.example.ndsp_project.model.Authors;
import com.example.ndsp_project.model.Publisher;
import com.example.ndsp_project.service.RetrofitService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAuthorActivity extends AppCompatActivity {

    private TextView authorid;
    List<Author> authorcategories = new ArrayList<>();
    private int BookList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_author);
        initActivity();

        Bundle bundle = getIntent().getExtras();
        BookList = bundle.getInt("BookList");
        authorid.setText(BookList);

        Log.e("BookList",String.valueOf(BookList));

    }

    private void initActivity() {


        authorid = findViewById(R.id.author_id);


//        getAuthorDetail();

    }

//    private void getAuthorDetail() {
//
//        Log.e("getDoctorDetail","success");
//        Api AuthorDetailApi = service.getRetrofitService().create(Api.class);
//        AuthorDetailApi.getAuthorList().enqueue(new Callback<AuthorDetailResponse>() {
//            @Override
//            public void onResponse(Call<AuthorDetailResponse> call, Response<AuthorDetailResponse> response) {
//                if (response.isSuccessful()){
//
//                    Authors authorDetail = response.body().authors.get(0);
//                    authorid.setText(authorDetail.id);
//                    authorbooktitle.setText(authorDetail.authorName);
//                    authorcover.setText(authorDetail.bookcoverimgurl);
//                    authorbooksale.setText(authorDetail.booksaleprice);
//                    author.setText(authorDetail.author);
//                    authorebook.setText(authorDetail.ebooksize);
//                    authorcategory.setText(authorDetail.category);
//                    authorrating.setText(authorDetail.rating);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<AuthorDetailResponse> call, Throwable t) {
//
//                Log.e("onfailure", t.toString());
//
//            }
//        });

    }



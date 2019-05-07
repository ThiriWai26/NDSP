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
import com.example.ndsp_project.Response.AuthorListResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorActivity extends AppCompatActivity {

    private ListView AuthorList;
    List<Author> authorcategories = new ArrayList<>();
    private RetrofitService service;

    List<String> authors = new ArrayList<>();
    ArrayAdapter<String> dataadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        initAuthorList();

    }

    private void getAuthorList() {

        final Api authorListApi = service.getRetrofitService().create(Api.class);
        authorListApi.getAuthorList().enqueue(new Callback<AuthorListResponse>() {
            @Override
            public void onResponse(Call<AuthorListResponse> call, Response<AuthorListResponse> response) {

                if (response.isSuccessful()) {
                    authorcategories.addAll(response.body().authors);
                    Log.e("response", String.valueOf(response.body().authors.size()));
                    for (int i = 0; i < authorcategories.size(); i++) {
                        authors.add(authorcategories.get(i).authorName);
                    }
                    dataadapter.notifyDataSetChanged();
                    AuthorList.setAdapter(dataadapter);
                }
            }

            @Override
            public void onFailure(Call<AuthorListResponse> call, Throwable t) {
                Log.e("onfailure", t.toString());

            }
        });

    }


    private void initAuthorList() {

        service = new RetrofitService();
        AuthorList = findViewById(R.id.authorlist);
        getAuthorList();

//        String books[]={"apple","orange","cup","dog"};

        dataadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, authors);

        AuthorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String BookList = dataadapter.getItem(position);
                Log.e("bookcategoriesid", String.valueOf(authorcategories.get(position).id));
                Log.e("position", String.valueOf(position));

                Intent intent = new Intent(getApplicationContext(), AuthorDetailActivity.class);
//                intent.putExtra("authorId", authorcategories.get(position).id);
                intent.putExtra("book_id", authorcategories.get(position).id);

                Log.e("authorActivity_id",authorcategories.get(position).id);
                startActivity(intent);



//                Toast.makeText(getApplicationContext(), BookList, Toast.LENGTH_SHORT).show();

//                String BookList = dataadapter.getItem(position);
//                String userId = BookList.substring(BookList.indexOf(""));
//                Intent intent1 = new Intent(AuthorActivity.this,ListAuthorActivity.class);
//                intent1.putExtra("BookList", userId);
//                startActivity(intent1);
//                Toast.makeText(getBaseContext(), id + "", Toast.LENGTH_LONG).show();
            }
        });

    }
}

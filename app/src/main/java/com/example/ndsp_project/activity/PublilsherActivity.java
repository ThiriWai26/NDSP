package com.example.ndsp_project.activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.PublisherListResponse;
import com.example.ndsp_project.adapter.PublisherAdapter;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.Publisher;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublilsherActivity extends AppCompatActivity {

    private ListView PublisherList;
    private RetrofitService service;

    List<Publisher> publishercategories = new ArrayList<>();
    List<String> publishers = new ArrayList<>();

    ArrayAdapter<String> dataadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publilsher);

        initPublisherList();
    }

    private void initPublisherList() {

        PublisherList = findViewById(R.id.publisherlist);
        service = new RetrofitService();

        getPublisherList();
        dataadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, publishers);

        PublisherList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String BookList = dataadapter.getItem(position);
                Log.e("publishercategories", publishercategories.get(position).id);
                Log.e("position", String.valueOf(position));
                Intent intent =new Intent(getApplicationContext(), PublisherDetailActivity.class);
                intent.putExtra("book_id", publishercategories.get(position).id);

                Log.e("publisherActivity_id",String.valueOf(publishercategories.get(position).id));
                startActivity(intent);

            }
        });

    }


    private void getPublisherList() {

        Api getPublisherList = service.getRetrofitService().create(Api.class);
        getPublisherList.getPublisherList().enqueue(new Callback<PublisherListResponse>() {
            @Override
            public void onResponse(Call<PublisherListResponse> call, Response<PublisherListResponse> response) {

                if (response.isSuccessful()) {
                    publishercategories.addAll(response.body().publishers);
                    Log.e("response", String.valueOf(response.body().publishers.size()));
                    for (int i = 0; i < publishercategories.size(); i++) {
                        publishers.add(publishercategories.get(i).publishername);
                    }
                    dataadapter.notifyDataSetChanged();
                    PublisherList.setAdapter(dataadapter);
                }

            }

            @Override
            public void onFailure(Call<PublisherListResponse> call, Throwable t) {

                Log.e("onfailure", t.toString());


            }
        });

    }

}
package com.example.ndsp_project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.PublisherListResponse;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.Publisher;
import com.example.ndsp_project.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPublisherActivity extends AppCompatActivity {

    private TextView publisherid;
    List<Author> publishercategories = new ArrayList<>();
    private String BookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_publisher);

        initActivity();

        Bundle bundle = getIntent().getExtras();
        BookList = bundle.getString("BookList");

        publisherid.setText(BookList);
        Log.e("booklist",BookList);

    }

    private void initActivity() {

        publisherid = findViewById(R.id.publisher_id);

    }

}

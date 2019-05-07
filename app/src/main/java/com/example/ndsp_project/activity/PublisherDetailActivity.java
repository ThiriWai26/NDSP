package com.example.ndsp_project.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ndsp_project.R;
import com.example.ndsp_project.Response.PublisherDetailResponse;
import com.example.ndsp_project.adapter.AuthorAdapter;
import com.example.ndsp_project.adapter.PublisherAdapter;
import com.example.ndsp_project.api.Api;
import com.example.ndsp_project.holder.publisherholders;
import com.example.ndsp_project.model.PublisherDetail;
import com.example.ndsp_project.service.RetrofitService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublisherDetailActivity extends AppCompatActivity implements publisherholders.OnPublisherClickListener{


    private RetrofitService service;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private String BookList;
    private TextView title,name,price;
    private ImageView imageView;


    List<PublisherDetail> publishercategories = new ArrayList<>();

    private PublisherAdapter adapter;
    private ArrayAdapter<String> dataAdapter;

    List<PublisherDetail> publishers = new ArrayList<>();
    List<PublisherDetail> newPublishers = new ArrayList<PublisherDetail>();
    private LinearLayoutManager linearLayoutManager;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_detail);
        initActivity();

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        searchViewModify();
    }

    private void initActivity() {

        service = new RetrofitService();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PublisherAdapter(this);

        Bundle bundle=getIntent().getExtras();
        BookList=bundle.getString("book_id");
        Log.e("publisher_id",String.valueOf(BookList));

        adapter = new PublisherAdapter(this);


        getPublisherDetail();
//        searchViewFilter();


    }

    private void getPublisherDetail() {

        Log.e("getpublisherdetail","success");
        Api publisherDetailApi = service.getRetrofitService().create(Api.class);

        publisherDetailApi.getPublisherDetail(BookList).enqueue(new Callback<PublisherDetailResponse>() {
            @Override
            public void onResponse(Call<PublisherDetailResponse> call, Response<PublisherDetailResponse> response) {
                if(response.isSuccessful()){

                      //output publishersize
                    publishercategories.addAll(response.body().publishers);
                    Log.e("publisherList", String.valueOf(response.body().publishers.size()));

                    adapter.addItem(response.body().publishers);
                    Log.e("publisherList", String.valueOf(response.body().publishers.size()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(adapter);

                  }
                }

            @Override
            public void onFailure(Call<PublisherDetailResponse> call, Throwable t) {

                Log.e("onfailure", t.toString());
            }
        });


    }


//    private void searchViewFilter() {
//
//        searchView.setOnQueryTextFocusChangeListener(new SearchView.OnQueryTextListener() {
//            public boolean onQueryTextSubmit(String s) {
//
//                s = s.toLowerCase(Locale.getDefault());
//                if (s.length() != 0) {
//                    newPublishers.clear();
//                    for (PublisherDetail publishers : publishers) {
//                        if (publishers.author.toLowerCase(Locale.getDefault()).contains(s)) {
//
//                            newPublishers.add(publishers);
//                        }
//                    }
//                    adapter.addItem(newPublishers);
//                } else {
//                    adapter.addItem(publishers);
//                }
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                s = s.toLowerCase(Locale.getDefault());
//                if (s.length() != 0) {
//                    newPublishers.clear();
//                    for (PublisherDetail publishers : publishers) {
//                        if (publishers.author.toLowerCase(Locale.getDefault()).contains(s)) {
//
//                            newPublishers.add(publishers);
//                        }
//                    }
//                    adapter.addItem(newPublishers);
//                } else {
//                    adapter.addItem(publishers);
//                }
//
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
//
//    }

//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    private void searchViewModify() {
//        searchView.setIconified(false);
//        searchView.setIconifiedByDefault(false);
//        android.support.v7.widget.SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
//        searchAutoComplete.setHint("Search");
//        searchAutoComplete.setHintTextColor(Color.WHITE);
//        searchAutoComplete.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
//
//        ImageView searchIcon = searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
//        searchIcon.focusSearch(View.FOCUS_RIGHT);




//    }

    public void onPublisherClick(int id) {




    }
}



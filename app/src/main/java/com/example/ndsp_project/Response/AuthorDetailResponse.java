package com.example.ndsp_project.Response;

import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.AuthorDetail;
import com.example.ndsp_project.model.Authors;
import com.example.ndsp_project.model.PublisherDetail;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AuthorDetailResponse {

    @SerializedName("current_page")
    public int currentPage;

    @SerializedName("data")
    public ArrayList<AuthorDetail> author;

    @SerializedName("frist_page_url")
    public String firstPage;

    @SerializedName("from")
    public int from;

    @SerializedName("last_page")
    public int lastPage;

    @SerializedName("last_page_url")
    public String LastPage;

    @SerializedName("next_page_url")
    public String nextPage;

    @SerializedName("path")
    public String path;

    @SerializedName("per_page")
    public int perPage;

    @SerializedName("prev_page_url")
    public String prevPage;

    @SerializedName( "to")
    public int to;

    @SerializedName("total")
    public int total;



}

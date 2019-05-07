package com.example.ndsp_project.Response;

import com.example.ndsp_project.model.PublisherDetail;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PublisherDetailResponse {

    @SerializedName("current_page")
    public int currentPage;

    @SerializedName("data")
    public List<PublisherDetail> publishers;

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







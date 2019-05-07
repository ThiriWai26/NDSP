package com.example.ndsp_project.Response;

import com.example.ndsp_project.model.Author;
import com.example.ndsp_project.model.AuthorList;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class AuthorListResponse {

    @SerializedName("first_page_url")
    public String FirstPageUrl;

    @SerializedName("last_page_url")
    public String lastPageUrl;

    @SerializedName("next_page_url")
    public String nextPageUrl;

    @SerializedName("path")
    public String path;

    @SerializedName("prev_page_url ")
    public String prevPageUrl;

    @SerializedName("data")
    public ArrayList<Author> authors;



}

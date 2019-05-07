package com.example.ndsp_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AuthorDetail {

    @SerializedName("id")
    public int id;

    @SerializedName("bookTitle")
    public String booktitle;

    @SerializedName("bookCoverImgUrl")
    public String bookcover;

    @SerializedName("bookSalePrice")
    public int booksaleprice;

    @SerializedName("author")
    public String author;

    @SerializedName("ebook_size")
    public String ebooksize;

    @SerializedName("category")
    public String category;

    @SerializedName("rating")
    public int rating;

}

package com.example.ndsp_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PublisherDetail {

    @SerializedName("id")
    public int id;

    @SerializedName("edition_id")
    public int edtid;

    @SerializedName("publisher_id")
    public int publisher_id;

    @SerializedName("bookTitle")
    public String booktitle;

    @SerializedName("bookDescription")
    public String bookdescription;

    @SerializedName("bookSalePrice")
    public int booksaleprice;

    @SerializedName("bookCoverImgUrl")
    public static String bookcover;

    @SerializedName("isEbook")
    public int ebook;

    @SerializedName("e_book_download")
    public String ebookdownload;

    @SerializedName("buy_or_consigment")
    public int buy;

    @SerializedName("author")
    public String author;

    @SerializedName("ebook_size")
    public String ebooksize;

    @SerializedName("category")
    public String category;

    @SerializedName("rating")
    public int rating;




}

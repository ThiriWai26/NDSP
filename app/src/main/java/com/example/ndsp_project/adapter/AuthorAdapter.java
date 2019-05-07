package com.example.ndsp_project.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ndsp_project.holder.AuthorHolder;
import com.example.ndsp_project.model.AuthorDetail;

import java.util.ArrayList;
import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorHolder>{

    List<AuthorDetail> authorLists;
    AuthorHolder.OnAuthorClickListener listener;

    public AuthorAdapter(AuthorHolder.OnAuthorClickListener listener) {

        authorLists = new ArrayList<>();
        this.listener = listener;
    }


    @NonNull
    @Override
    public AuthorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        return AuthorHolder.create(inflater,viewGroup,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorHolder authorHolder, int i) {

        authorHolder.bindData(authorLists.get(i));


    }

    @Override
    public int getItemCount() {
        Log.e("size",String.valueOf(authorLists.size()));
        return authorLists.size();
    }

    public void addItem(List<AuthorDetail> author){

//        this.authorLists.clear();
//        this.authorLists.addAll(author);
        this.authorLists = author;
        notifyDataSetChanged();

    }
}

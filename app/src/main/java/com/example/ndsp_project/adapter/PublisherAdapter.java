package com.example.ndsp_project.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ndsp_project.activity.PublisherDetailActivity;
import com.example.ndsp_project.holder.publisherholders;
import com.example.ndsp_project.model.PublisherDetail;

import java.util.ArrayList;
import java.util.List;

public class PublisherAdapter extends RecyclerView.Adapter<publisherholders> {

    List<PublisherDetail> publisherLists ;
    publisherholders.OnPublisherClickListener listener;


    public PublisherAdapter(PublisherDetailActivity listener){

        publisherLists =new ArrayList<>();
        this.listener=listener;
    }

    @NonNull
    @Override
    public publisherholders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        return publisherholders.create(inflater,viewGroup,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull publisherholders publisherholder, int i) {

        publisherholder.bindData(publisherLists.get(i));
    }


    @Override
    public int getItemCount() {
        return publisherLists.size();
    }


    public void addItem(List<PublisherDetail> publisher){

        this.publisherLists = publisher;
        notifyDataSetChanged();

    }

}



package com.example.ndsp_project.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ndsp_project.R;
import com.example.ndsp_project.model.PublisherDetail;
import com.squareup.picasso.Picasso;

public class publisherholders extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnPublisherClickListener listener;
    private TextView title,price,name,tvid;
    private ImageView imageView;
    RelativeLayout layout;

    public publisherholders(@NonNull View itemView, OnPublisherClickListener listener) {

        super(itemView);
        this.listener = listener;
        initView(itemView);
        itemView.setOnClickListener(this);
    }

    private void initView(View itemView) {

        tvid = itemView.findViewById(R.id.tvid);
        title = itemView.findViewById(R.id.tvtitle);
        price = itemView.findViewById(R.id.tvprice);
        name = itemView.findViewById(R.id.tvname);
        imageView= itemView.findViewById(R.id.profile);
        layout = imageView.findViewById(R.id.publisher_layout_list);

    }

    public static publisherholders create(LayoutInflater inflater, ViewGroup viewGroup, OnPublisherClickListener listener) {

        View view = inflater.inflate(R.layout.layout_publisher_list, viewGroup, false);
        return new publisherholders(view, listener);
    }

    public void bindData(PublisherDetail publisher) {

        title.setText(publisher.booktitle);
        price.setText(publisher.booksaleprice);
        name.setText(publisher.author);

        Log.e("bookcovername",publisher.bookcover);


        Picasso.get()
                .load("http://128.199.217.182/api/get_image/" + publisher.bookcover)
                .resize(800, 700)
                .centerCrop()
                .into(imageView);
    }

    @Override
    public void onClick(View v) {

        listener.onPublisherClick(Integer.parseInt(tvid.getText().toString()));
        int position;
        position = getAdapterPosition();
        Log.e("position",String.valueOf(position));


    }


    public interface  OnPublisherClickListener {
         void onPublisherClick (int id);
    }


}



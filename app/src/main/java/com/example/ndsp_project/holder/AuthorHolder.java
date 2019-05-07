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
import com.example.ndsp_project.model.AuthorDetail;
import com.squareup.picasso.Picasso;

public class AuthorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnAuthorClickListener listener;
    private TextView title,price,name,tvid;
    private ImageView imageView;
    RelativeLayout layout;


    public AuthorHolder(@NonNull View itemView, OnAuthorClickListener listener) {

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
        layout=itemView.findViewById(R.id.author_layout_list);

    }


    public void bindData(AuthorDetail author) {

        title.setText(author.booktitle);
        price.setText(String.valueOf(author.booksaleprice));
        name.setText(author.author);

        Log.e("bookcovername",author.bookcover);

        Picasso.get()
                .load("http://128.199.217.182/api/image/book/" + author.bookcover)
                .resize(800,700)
                .centerCrop()
                .into(imageView);
    }


    @Override
    public void onClick(View v) {

        listener.onAuthorClick(Integer.parseInt(tvid.getText().toString()));
        int position;
        position = getAdapterPosition();

        Log.e("position",String.valueOf(position));

    }

    public static AuthorHolder create(LayoutInflater inflater, ViewGroup viewGroup, OnAuthorClickListener listener) {

        View view = inflater.inflate(R.layout.layout_author_list, viewGroup, false);
        return new AuthorHolder(view, listener);
    }


    public interface  OnAuthorClickListener  {
        void onAuthorClick (int id);
    }

}

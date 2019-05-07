//package com.example.ndsp_project.holder;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.ndsp_project.R;
//import com.example.ndsp_project.activity.PublisherDetailActivity;
//import com.example.ndsp_project.model.Publisher;
//
//public class PublisherHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
//
//    private PublisherDetailActivity listener;
//    private TextView title,price,name,rating,tvid;
//    private ImageView imageView;
//
//    public interface OnPublisherClickListener {
//
//            public void onPublisherClick(int id);
//    }
//
//
//    public PublisherHolder(@NonNull View itemView, PublisherDetailActivity listener) {
//        super(itemView);
//        this.listener = listener;
//        initView(itemView);
//    }
//
//
//    private void initView(View itemView) {
//
//        tvid = itemView.findViewById(R.id.tvid);
//        title = itemView.findViewById(R.id.tvtitle);
//        price = itemView.findViewById(R.id.tvprice);
//        name = itemView.findViewById(R.id.tvname);
//        rating = itemView.findViewById(R.id.rating);
//
//        itemView.setOnClickListener(this);
//
//    }
//
//
//    public static PublisherHolder create(LayoutInflater inflater, ViewGroup viewGroup, PublisherDetailActivity listener) {
//
//        View view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, viewGroup, false);
//        return new PublisherHolder(view, listener);
//    }
//
//    public static void bindData(Publisher publishers) {
//
//
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//
//        listener.onPublisherClick(Integer.parseInt((String) tvId.getText()));
//        int position;
//        position = getAdapterPosition();
//        Log.e("position", String.valueOf(position));
//
//
//    }
//}
//

package com.example.ndsp_project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ndsp_project.R;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {

    private Button author,publisher,genre;
    private String token;
    private Intent intent;
    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initBook();
    }

    private void initBook() {

        author = findViewById(R.id.btn_author);
        publisher = findViewById(R.id.btn_publisher);
        genre = findViewById(R.id.btn_genre);

        author.setOnClickListener(this);
        publisher.setOnClickListener(this);
        genre.setOnClickListener(this);

        b = getIntent().getExtras();

//        token = b.getString("Token");
//
//        Log.e("HomeActivityToken", token);

    }

    @Override
    public void onClick(View v) {

        if (v == author) {

            intent = new Intent(BookActivity.this, AuthorActivity.class);
            startNextActivity(intent);

        }

        if ( v == publisher) {

            intent = new Intent(BookActivity.this, PublilsherActivity.class);
            startNextActivity(intent);

        }

        if ( v == genre) {

            intent = new Intent(BookActivity.this, GenreActivity.class);
            startNextActivity(intent);

        }

    }

    private void startNextActivity (Intent intent) {

        intent.putExtra("Token", token);
        startActivity(intent);
    }
}

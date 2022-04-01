package com.example.wearcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_discussion, btn_movies, btn_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btn_discussion.findViewById(R.id.btn_discussion);
//        btn_discussion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ChatList.class);
//                startActivity(intent);
//            }
//        });
//
//        btn_movies.findViewById(R.id.btn_movies);
//        btn_movies.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Movies.class);
//                startActivity(intent);
//            }
//        });
    }

    public void films(View view) {
        Intent intent = new Intent(MainActivity.this, Movies.class);
        startActivity(intent);
    }

    public void discussion(View view) {
        Intent intent = new Intent(MainActivity.this, ChatList.class);
        startActivity(intent);
    }
}
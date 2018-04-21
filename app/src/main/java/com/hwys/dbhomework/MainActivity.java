package com.hwys.dbhomework;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnGenre, btnMovie, btnMovieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControls();
    }

    void initializeControls(){
        btnGenre = findViewById(R.id.btnGenre);
        btnGenre.setOnClickListener(this);
        btnMovie = findViewById(R.id.btnMovieEntry);
        btnMovie.setOnClickListener(this);
        btnMovieList = findViewById(R.id.btnMovieList);
        btnMovieList.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent i = null;
        switch (v.getId()){
            case R.id.btnGenre:
                i = new Intent(getApplicationContext(), GenreActivity.class);
                break;

            case R.id.btnMovieEntry:
                i = new Intent(getApplicationContext(), MovieEntryActivity.class);
                break;

            case R.id.btnMovieList:
                i = new Intent(getApplicationContext(), MovieListActivity.class);
                break;


        }
        startActivity(i);
    }
}

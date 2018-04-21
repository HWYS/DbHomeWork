package com.hwys.dbhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.hwys.dbhomework.adapter.GenreSpinnerAdapter;
import com.hwys.dbhomework.adapter.MovieRecyclerAdapter;
import com.hwys.dbhomework.data_model.GenreInfo;
import com.hwys.dbhomework.data_model.MovieInfo;
import com.hwys.dbhomework.database.DatabaseHelper;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    List<GenreInfo> genreInfoList; List<MovieInfo> movieInfoList;

    AppCompatSpinner spnGenre; RecyclerView rvMovie;
    DatabaseHelper databaseHelper;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        initializeControls();
    }

    void  initializeControls(){
        databaseHelper = new DatabaseHelper(getApplicationContext(), "MovieDb", null, 1);

        genreInfoList = databaseHelper.getAllGenre();

        GenreSpinnerAdapter spinnerAdapter = new GenreSpinnerAdapter(genreInfoList);
        spnGenre = findViewById(R.id.spnGenre);
        spnGenre.setAdapter(spinnerAdapter);

        rvMovie = findViewById(R.id.rvMovie);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMovie.setLayoutManager(layoutManager);
        rvMovie.setHasFixedSize(true);

        spnGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                movieInfoList = databaseHelper.getMovieByGenre(genreInfoList.get(position).getId());
                MovieRecyclerAdapter adapter = new MovieRecyclerAdapter(movieInfoList);
                rvMovie.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

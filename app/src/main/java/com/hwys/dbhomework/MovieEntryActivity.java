package com.hwys.dbhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.hwys.dbhomework.adapter.GenreRecyclerAdapter;
import com.hwys.dbhomework.adapter.GenreSpinnerAdapter;
import com.hwys.dbhomework.data_model.GenreInfo;
import com.hwys.dbhomework.data_model.MovieInfo;
import com.hwys.dbhomework.database.DatabaseHelper;

import java.util.List;

public class MovieEntryActivity extends AppCompatActivity {
    AppCompatSpinner spnGenre; EditText etMovieName, etIncome, etProduction, etRating, etYear;

    List<GenreInfo> genreInfoList; DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_entry);

        initializeControls();
    }

    void initializeControls(){
        databaseHelper = new DatabaseHelper(getApplicationContext(), "MovieDb", null, 1);
        genreInfoList = databaseHelper.getAllGenre();

        spnGenre = findViewById(R.id.spnGenre);
        GenreSpinnerAdapter adapter = new GenreSpinnerAdapter(genreInfoList);
        spnGenre.setAdapter(adapter);

        Toolbar tbToolbar = findViewById(R.id.tbToolbar);
        setSupportActionBar(tbToolbar);

        etMovieName = findViewById(R.id.etMovieName);
        etIncome = findViewById(R.id.etIncome);
        etProduction = findViewById(R.id.etProduction);
        etRating = findViewById(R.id.etRating);
        etYear = findViewById(R.id.etYear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.genre_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MovieInfo info = new MovieInfo();
        info.setId(genreInfoList.get(spnGenre.getSelectedItemPosition()).getId());
        info.setmName(etMovieName.getText().toString());
        info.setIncome(Double.parseDouble(etIncome.getText().toString()));
        info.setRating(Double.parseDouble(etRating.getText().toString()));
        info.setProduction(etProduction.getText().toString());
        info.setYear(etYear.getText().toString());
        if(databaseHelper.addMovie(info)){
            Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(getApplicationContext(), "Saved Failed", Toast.LENGTH_LONG).show();
        return  true;
    }
}

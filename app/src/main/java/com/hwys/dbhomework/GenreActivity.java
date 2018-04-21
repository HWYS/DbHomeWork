package com.hwys.dbhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.hwys.dbhomework.adapter.GenreRecyclerAdapter;
import com.hwys.dbhomework.data_model.GenreInfo;
import com.hwys.dbhomework.database.DatabaseHelper;

import java.util.List;

public class GenreActivity extends AppCompatActivity {
    EditText etGenre; RecyclerView rvGenre;
    Toolbar tbToolbar;
    GenreRecyclerAdapter adapter; DatabaseHelper databaseHelper;
    List<GenreInfo> genreInfoList;

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        initializeControls();
    }

    void initializeControls(){
        databaseHelper = new DatabaseHelper(getApplicationContext(), "MovieDb", null, 1);

        tbToolbar = findViewById(R.id.tbToolbar);
        setSupportActionBar(tbToolbar);
        etGenre = findViewById(R.id.etGenre);
        rvGenre = findViewById(R.id.rvGenre);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvGenre.setLayoutManager(layoutManager);
        rvGenre.setHasFixedSize(true);
        genreInfoList  = databaseHelper.getAllGenre();
        adapter = new GenreRecyclerAdapter(genreInfoList);
        rvGenre.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.genre_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(databaseHelper.addGenre(etGenre.getText().toString())){
            Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
            genreInfoList = databaseHelper.getAllGenre();
            adapter.updateList(genreInfoList);
            adapter.notifyDataSetChanged();
        }
        else
            Toast.makeText(getApplicationContext(), "Saved Failed", Toast.LENGTH_LONG).show();
        return  true;
    }
}

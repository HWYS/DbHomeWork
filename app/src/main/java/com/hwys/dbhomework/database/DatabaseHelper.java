package com.hwys.dbhomework.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hwys.dbhomework.data_model.GenreInfo;
import com.hwys.dbhomework.data_model.MovieInfo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_Genre (id INTEGER PRIMARY KEY, genre TEXT)");
        db.execSQL("CREATE TABLE tbl_Movie(m_id INTEGER PRIMARY KEY, id INTEGER, m_name TEXT, production TEXT" +
                ", income REAL, rating REAL, year TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addGenre(String genre){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("genre", genre);

        try{
            db.insert("tbl_Genre", null, cv);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public boolean addGenre(GenreInfo genre){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("genre", genre.getGenre());

        try{
            db.insert("tbl_Genre", null, cv);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<GenreInfo> getAllGenre(){
        List<GenreInfo> genreInfoList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Genre", null);

        if(cursor.moveToFirst()){
            do{
                GenreInfo info = new GenreInfo();
                info.setId(cursor.getInt(cursor.getColumnIndex("id")));
                info.setGenre(cursor.getString(cursor.getColumnIndex("genre")));

                genreInfoList.add(info);
            }while (cursor.moveToNext());
        }

        return genreInfoList;
    }

    public boolean addMovie(MovieInfo info){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("id", info.getId());
        cv.put("m_name", info.getmName());
        cv.put("production", info.getProduction());
        cv.put("income", info.getIncome());
        cv.put("rating", info.getRating());
        cv.put("year", info.getYear());

        try{
            db.insert("tbl_Movie", null, cv);
            return true;
        }catch (Exception e){return false;}
    }

    public List<MovieInfo> getMovieByGenre(int id){
        List<MovieInfo> movieInfoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //**** Hello this is version control test *****


        Cursor cursor = db.rawQuery("SELECT * FROM tbl_Movie WHERE id="+id, null);

        if(cursor.moveToFirst()){
            do{
                MovieInfo info = new MovieInfo();
                info.setM_id(cursor.getInt(cursor.getColumnIndex("m_id")));
                info.setId(cursor.getInt(cursor.getColumnIndex("id")));
                info.setmName(cursor.getString(cursor.getColumnIndex("m_name")));
                info.setProduction(cursor.getString(cursor.getColumnIndex("production")));
                info.setIncome(cursor.getDouble(cursor.getColumnIndex("income")));
                info.setRating(cursor.getDouble(cursor.getColumnIndex("rating")));
                info.setYear(cursor.getString(cursor.getColumnIndex("year")));

                movieInfoList.add(info);
            }while (cursor.moveToNext());
        }
        return movieInfoList;//****
    }
}

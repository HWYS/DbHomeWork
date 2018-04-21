package com.hwys.dbhomework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hwys.dbhomework.R;
import com.hwys.dbhomework.data_model.GenreInfo;

import java.util.List;

public class GenreSpinnerAdapter extends BaseAdapter {

    List<GenreInfo> genreInfoList;

    public GenreSpinnerAdapter(List<GenreInfo> genreInfoList) {
        this.genreInfoList = genreInfoList;
    }

    @Override
    public int getCount() {
        return genreInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return genreInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list_item, parent, false);

        TextView tvGenre = convertView.findViewById(R.id.tvGenre);
        tvGenre.setText(genreInfoList.get(position).getGenre());

        return  convertView;
    }
}

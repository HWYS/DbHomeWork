package com.hwys.dbhomework.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hwys.dbhomework.R;
import com.hwys.dbhomework.data_model.GenreInfo;

import java.util.List;

public class GenreRecyclerAdapter extends RecyclerView.Adapter<GenreRecyclerAdapter.MyViewHolder> {

    List<GenreInfo> genreInfoList;

    public GenreRecyclerAdapter(List<GenreInfo> genreInfoList) {
        this.genreInfoList = genreInfoList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvGenre.setText(genreInfoList.get(position).getGenre());
    }

    @Override
    public int getItemCount() {
        return genreInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvGenre;
        public MyViewHolder(View itemView) {
            super(itemView);

            tvGenre = itemView.findViewById(R.id.tvGenre);
        }
    }

    public void updateList(List<GenreInfo> infos){
        genreInfoList = infos;

    }
}

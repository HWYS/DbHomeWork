package com.hwys.dbhomework.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hwys.dbhomework.R;
import com.hwys.dbhomework.data_model.MovieInfo;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MyViewHolder> {

    List<MovieInfo> movieInfoList;

    public MovieRecyclerAdapter(List<MovieInfo> movieInfoList) {
        this.movieInfoList = movieInfoList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvMovieName.setText(movieInfoList.get(position).getmName());
        holder.tvRating.setText(String.valueOf(movieInfoList.get(position).getRating()));
        holder.tvIncome.setText(String.valueOf(movieInfoList.get(position).getIncome()));
        holder.tVProduction.setText(movieInfoList.get(position).getProduction());
        holder.tvYear.setText(movieInfoList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvGenre, tvMovieName, tVProduction, tvIncome, tvRating, tvYear;
        public MyViewHolder(View itemView) {
            super(itemView);

            //tvGenre = itemView.findViewById(R.id.tvGenre);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            tVProduction = itemView.findViewById(R.id.tvProduction);
            tvIncome = itemView.findViewById(R.id.tvIncome);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvYear = itemView.findViewById(R.id.tvYear);
        }
    }

    public void updateList(List<MovieInfo> infos){
        movieInfoList = infos;

    }
}

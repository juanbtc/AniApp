package org.jbtc.aniapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> items = new ArrayList<>();

    public void setItems(List<Anime> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_anime,parent,false);
        AnimeViewHolder animeViewHolder = new AnimeViewHolder(v);
        return animeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: se ejecuto el on bind");
        holder.name.setText( items.get(position).getTitles().getEn() );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cv_anime_name);
        }
    }
}
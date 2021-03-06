package org.jbtc.aniapp.adapter;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.jbtc.aniapp.R;
import org.jbtc.aniapp.model.Anime;


import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.model.Anime;

import java.io.InputStream;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> items = new ArrayList<>();

    //private Anime item= new Anime();


    public AnimeAdapter(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setItems(List<Anime> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    /*public void setItem(Anime item) {
        this.item = item;
        notifyDataSetChanged();
    }*/



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


        Picasso.get()
                .load(items.get(position).getCover_image())
                .fit().centerCrop()
                .into(holder.cover_image);

        //holder.description.setText(items.get(position).getDescriptions().getEn());
        //new DownLoadImageTask(holder.cover_image).execute(items.get(position).getCover_image());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
        ShapeableImageView imageView;

        public DownLoadImageTask(ShapeableImageView imageView) {
            this.imageView = imageView;
        }


        @Override
        protected Bitmap doInBackground(String... urls) {
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try {
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            } catch (Exception e) { // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView cover_image;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cv_anime_name);
            cover_image = itemView.findViewById(R.id.cv_anime_cover_image);

            itemView.setOnClickListener(view -> {
                onClick.onClickCard( items.get(getAdapterPosition()) );
            });
        }



    }

    OnClick onClick;
    public interface OnClick{
        void onClickCard(Anime anime);
    }

}

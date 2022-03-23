package org.jbtc.aniapp.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.model.Anime;
import org.jbtc.aniapp.model.Episode;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {
    private List<Episode> items = new ArrayList<>();
    private Anime item= new Anime();

    public void setItems(List<Episode> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    public void setItem(Anime item) {
        this.item = item;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_episode,parent,false);
        EpisodeViewHolder episodeViewHolder = new EpisodeViewHolder(v);
        return episodeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: se ejecuto el on bind");
        holder.name.setText( items.get(position).getTitle());
        int numero=items.get(position).getNumber();
        holder.number.setText(item.getTitles().getEn());
        holder.video.loadUrl(items.get(position).getVideo());
       // new EpisodeViewHolder.DownLoadImageTask(holder.cover_image).execute(items.get(position).getCover_image());

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    static class EpisodeViewHolder extends RecyclerView.ViewHolder{

         TextView name;
         TextView number;
         WebView  video;


        public EpisodeViewHolder(@NonNull View itemView) {

            super(itemView);

             name = itemView.findViewById(R.id.cv_episode_name);
             number= itemView.findViewById(R.id.cv_episode_numero);
             video = itemView.findViewById(R.id.cv_episode_video);

        }


        private static class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {
            ShapeableImageView imageView;

            public DownLoadImageTask(ShapeableImageView imageView){
                this.imageView = imageView;
            }


            @Override
            protected Bitmap doInBackground(String... urls) {
                String urlOfImage = urls[0];
                Bitmap logo = null;
                try{
                    InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                    logo = BitmapFactory.decodeStream(is);
                }catch(Exception e){ // Catch the download exception
                    e.printStackTrace();
                }
                return logo;
            }

            protected void onPostExecute(Bitmap result){
                imageView.setImageBitmap(result);
            }
        }


    }
}
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
import org.jbtc.aniapp.model.Song;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> items = new ArrayList<>();
    private Song item= new Song();

    public void setItems(List<Song> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    public void setItem(Song item) {
        this.item = item;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_song,parent,false);
        SongViewHolder songViewHolder = new SongViewHolder(v);
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: se ejecuto el on bind");
        holder.name.setText( items.get(position).getTitle());
        holder.artist.setText("Artist:"+items.get(position).getArtist());
        holder.song.loadUrl(items.get(position).getPreview_url());


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SongViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView artist;
        WebView song;



        public SongViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.cv_song_name);
            artist = itemView.findViewById(R.id.cv_song_artist);
            song= itemView.findViewById(R.id.cv_song_preview_url);


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
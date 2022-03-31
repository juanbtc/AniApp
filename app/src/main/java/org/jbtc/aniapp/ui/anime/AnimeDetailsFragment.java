package org.jbtc.aniapp.ui.anime;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import org.jbtc.aniapp.MainActivity;
import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.database.AniApiRoom;
import org.jbtc.aniapp.databinding.FragmentAnimeDetailsBinding;
import org.jbtc.aniapp.model.Anime;
import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.provider.AniApiProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetailsFragment extends Fragment {
    private static final String TAG = "SLFG";
    private FragmentAnimeDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAnimeDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ( (MainActivity)getActivity() ).setDisplayShowTitleEnabled(true,false);



        Bundle b = getArguments();
        if(b!=null){
            int id = b.getInt("id",0);
            AnimeService animeService = AniApiProvider.getInstance().create(AnimeService.class);
            animeService.getAnime(id).enqueue(new Callback<RespuestaAnime>() {
                @Override
                public void onResponse(Call<RespuestaAnime> call, Response<RespuestaAnime> response) {
                    //AniApiRoom.getInstance(getContext()).animeDao().insertAnime(response.body().getData());
                    //List<Anime> a = AniApiRoom.getInstance(getContext()).animeDao().getAll();
                    //System.out.println("animes: "+a);

                    setAnimeToLayout(response.body().getData());
                }

                @Override
                public void onFailure(Call<RespuestaAnime> call, Throwable t) {

                }
            });
        }
    }

    private void setAnimeToLayout(Anime anime){

        //getActivity().setTitle(anime.getTitles().getEn());

        //getMainActivity().setDisplayShowTitleEnabled(true,false);
        //getMainActivity().setTitle(anime.getTitles().getEn());
            //getMainActivity().setExpandedAppbar(true);
        Log.i(TAG, "setAnimeToLayout: Anime: "+anime);

        //binding.tvDetailsAnimeTitle.setText(anime.getTitles().getEn());
        //binding.tvDetailsAnimeDescription.setText(Html.fromHtml(anime.getDescriptions().getEn()));
        //getMainActivity().loadImgToolbar(anime.getBanner_image());
        Picasso.get().load(anime.getCover_image()).into(binding.ivDetailsAnimeCover);

        binding.tvDetailsAnimeCalification.setText(anime.getScore()+"%");
        //Log.i(TAG, "setAnimeToLayout: generos"+anime.getGenres() );
        String generos="";
        //for (String genero : anime.getGenres()){
        //    generos+=genero+", ";
        //}StringBuffer g = new StringBuffer(generos);
        //g.deleteCharAt(g.length()-1);
        //g.deleteCharAt(g.length()-1);
        //binding.tvDetailsAnimeGeneros.setText(g);


        binding.tvDetailsAnimeFormat.setText( anime.getFormatToString() );
        binding.tvDetailsAnimeDiaEmision.setText( anime.getWeekly_airing_dayToString() );
        //binding.tvDetailsAnimeDateInit.setText(anime.getStart_date().toString());
        //binding.tvDetailsAnimeDateEnd.setText(anime.getEnd_date().toString());
        binding.tvDetailsAnimeCountE.setText(anime.getEpisodes_count()+" Episodios");
        System.out.println("val: "+anime.getSeason_period());
        binding.tvDetailsAnimeTemporada.setText(String.valueOf( anime.getSeason_period() ));
        //anime.getSagas()
        binding.tvDetailsAnimeStatus.setText( anime.getStatusToString() );
        binding.tvDetailsAnimeTrailer.setText(anime.getTrailer_url());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }


}

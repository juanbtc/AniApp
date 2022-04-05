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
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

import org.jbtc.aniapp.MainActivity;
import org.jbtc.aniapp.component.Fragmento;
import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.database.AniApiRoom;
import org.jbtc.aniapp.database.viewmodel.AnimeViewModel;
import org.jbtc.aniapp.databinding.FragmentAnimeDetailsBinding;
import org.jbtc.aniapp.model.Anime;
import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.provider.AniApiProvider;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetailsFragment extends Fragmento {
    private static final String TAG = "SLFG";
    private FragmentAnimeDetailsBinding binding;
    private AnimeViewModel animeViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAnimeDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        animeViewModel = new ViewModelProvider(this).get(AnimeViewModel.class);
        ( (MainActivity)getActivity() ).setDisplayShowTitleEnabled(true,false);



        Bundle b = getArguments();
        if(b!=null){
            int id = b.getInt("id",0);
            AnimeService animeService = AniApiProvider.getInstance().create(AnimeService.class);

            if(id>0)
                animeViewModel.getAnimeById(id)
                    .doOnError(throwable -> {
                        Log.e(TAG, "onViewCreated: error al obtener el anime mediante el id", throwable);
                        animeService.getAnime(id)
                                .enqueue(new Callback<RespuestaAnime>() {
                                    @Override
                                    public void onResponse(Call<RespuestaAnime> call, Response<RespuestaAnime> response) {
                                        Log.i(TAG, "onViewCreated: se obtubo el anime desde la api");
                                        setAnimeToLayout(response.body().getAnime());

                                            animeViewModel.insertAnime(response.body().getAnime())
                                                .subscribe((id_anime, throwable1) -> {
                                                        if(id_anime>0)
                                                            Log.i(TAG, "onResponse: Anime insertado con exito");
                                                        else
                                                            Log.e(TAG, "onResponse: hubo un erro al insertar el anime", throwable1);
                                                    });
                                                }
                                                @Override
                                                public void onFailure(Call<RespuestaAnime> call, Throwable t) {
                                                       Log.e(TAG, "onFailure: ", t);
                                                                     }
                                                });
                                            })
                    .flatMap(anime -> {
                        Log.i(TAG, "onViewCreated: se obtubo el anime desde room");
                        setAnimeToLayout(anime);
                        return Single.just(1);
                    }).subscribe((value, throwable) -> {
                        if(throwable!=null)
                            Log.e(TAG, "onViewCreated: error", throwable);
                    });

        }

    }

    private void setAnimeToLayout(Anime anime){

        //animeViewModel.getDescriptionsAndAnime()
                //.subscribe()

        ((MainActivity)getActivity()).setTitle(anime.getTitles().getEn());

        //getMainActivity().setDisplayShowTitleEnabled(true,false);
        getMainActivity().setTitle(anime.getTitles().getEn());
            //getMainActivity().setExpandedAppbar(true);
        Log.i(TAG, "setAnimeToLayout: Anime: "+anime);

        updateIconFab(anime);
        getMainActivity().setFabOnclickListener(view -> {
            if(anime.isFavorite())
                anime.setFavorite(false);
            else
                anime.setFavorite(true);

            animeViewModel.updateAnime(anime)
                    .subscribe((integer, throwable) -> {
                        if(integer>0){
                            Log.i(TAG, "setAnimeToLayout: Anime actualizado en room");
                            updateIconFab(anime);
                        }
                    });

        });


        binding.tvDetailsAnimeTitle.setText(anime.getTitles().getEn());
        //binding.tvDetailsAnimeDescription.setText(Html.fromHtml(anime.getDescriptions().getEn()));
        getMainActivity().loadImgToolbar(anime.getBanner_image());
        Picasso.get().load(anime.getCover_image()).into(binding.ivDetailsAnimeCover);

        binding.tvDetailsAnimeCalification.setText(anime.getScore()+"%");
        Log.i(TAG, "setAnimeToLayout: generos"+anime.getGenres() );
        String generos="";
        for (String genero : anime.getGenres()){
            generos+=genero+", ";
        }StringBuffer g = new StringBuffer(generos);
        g.deleteCharAt(g.length()-1);
        g.deleteCharAt(g.length()-1);
        binding.tvDetailsAnimeGeneros.setText(g);


        binding.tvDetailsAnimeFormat.setText( anime.getFormatToString() );
        binding.tvDetailsAnimeDiaEmision.setText( anime.getWeekly_airing_dayToString() );
        binding.tvDetailsAnimeDateInit.setText(anime.getStart_date().toString());
        binding.tvDetailsAnimeDateEnd.setText(anime.getEnd_date().toString());
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

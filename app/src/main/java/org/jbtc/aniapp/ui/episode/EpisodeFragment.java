package org.jbtc.aniapp.ui.episode;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import org.jbtc.aniapp.adapter.AnimeAdapter;
import org.jbtc.aniapp.adapter.EpisodeAdapter;

import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.contract.EpisodeService;
import org.jbtc.aniapp.databinding.FragmentEpisodeBinding;
import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.model.RespuestaEpisode;
import org.jbtc.aniapp.model.RespuestaEpisodes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.jbtc.aniapp.databinding.FragmentEpisodeBinding;

public class EpisodeFragment extends Fragment {

    FragmentEpisodeBinding binding;
    private EpisodeAdapter adapter;
    private AnimeAdapter animeAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding= FragmentEpisodeBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aniapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        EpisodeService episodeService = retrofit.create(EpisodeService.class);
        episodeService.getEpisodes().enqueue(new Callback<RespuestaEpisodes>() {
            @Override
            public void onResponse(Call<RespuestaEpisodes> call, Response<RespuestaEpisodes> response) {
                adapter.setItems(response.body().getData().getDocuments());
            }

            @Override
            public void onFailure(Call<RespuestaEpisodes> call, Throwable t) {
                Log.e("TAG", "onFailure: ", t);
            }
        });
        AnimeService animeService = retrofit.create(AnimeService.class);
        animeService.getAnime(3).enqueue(new Callback<RespuestaAnime>() {
            @Override
            public void onResponse(Call<RespuestaAnime> call, Response<RespuestaAnime> response) {
                adapter.setItem(response.body().getAnime());
            }

            @Override
            public void onFailure(Call<RespuestaAnime> call, Throwable t) {
                Log.e("TAG", "onFailure: ", t);
            }
        });

    }


    private void initAdapter() {
        binding.rvEpisodeList.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        binding.rvEpisodeList.setLayoutManager(gridLayoutManager);
        adapter = new EpisodeAdapter();
        binding.rvEpisodeList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

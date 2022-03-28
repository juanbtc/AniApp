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


import org.jbtc.aniapp.R;
import org.jbtc.aniapp.adapter.AnimeAdapter;
import org.jbtc.aniapp.adapter.EpisodeAdapter;

import org.jbtc.aniapp.component.PaginationFragment;
import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.contract.EpisodeService;
import org.jbtc.aniapp.databinding.FragmentEpisodeBinding;
import org.jbtc.aniapp.model.Pagination;
import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.model.RespuestaAnimes;
import org.jbtc.aniapp.model.RespuestaEpisode;
import org.jbtc.aniapp.model.RespuestaEpisodes;
import org.jbtc.aniapp.provider.AniApiProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpisodeFragment extends Fragment implements

        PaginationFragment.OnClickCallback {
    FragmentEpisodeBinding binding;
    private EpisodeAdapter adapter;
    private AnimeAdapter animeAdapter;

    private int page=0;
    private int total_page=0;
    public  int  id_anime_episode=0;

    private Callback<RespuestaEpisodes> callEpisodes = new Callback<RespuestaEpisodes>() {
        @Override
        public void onResponse(Call<RespuestaEpisodes> call, Response<RespuestaEpisodes> response) {
            if(response.isSuccessful())
                adapter.setItems(response.body().getData().getDocuments());
            page = response.body().getData().getCurrent_page();
            total_page = response.body().getData().getLast_page();
            PaginationFragment paginationFragment = (PaginationFragment) getChildFragmentManager().findFragmentById(R.id.frag_episode_pagination);
            paginationFragment.setEnumeration(page,total_page);
        }

        @Override
        public void onFailure(Call<RespuestaEpisodes> call, Throwable t) {
            Log.e("TAG", "onFailure: ", t);
        }
    };
    private Callback<RespuestaAnime> callAnime = new Callback<RespuestaAnime>() {
        @Override
        public void onResponse(Call<RespuestaAnime> call, Response<RespuestaAnime> response) {
            if(response.isSuccessful())
                adapter.setItem(response.body().getData());
        }

        @Override
        public void onFailure(Call<RespuestaAnime> call, Throwable t) {
            Log.e("TAG", "onFailure: ", t);
        }
    };


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
        PaginationFragment paginationFragment = (PaginationFragment) getChildFragmentManager().findFragmentById(R.id.frag_episode_pagination);
        paginationFragment.setOnClickCallback(this);
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aniapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            */

        EpisodeService episodeService = AniApiProvider.getInstance().create(EpisodeService.class);
         episodeService.getEpisodes(1).enqueue(callEpisodes);
        AnimeService animeService= AniApiProvider.getInstance().create(AnimeService.class);

        animeService.getAnime(1).enqueue(callAnime);
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

    @Override
    public void onClickPagination(int page) {
        EpisodeService episodeService = AniApiProvider.getInstance().create(EpisodeService.class);
        episodeService.getEpisodes(page).enqueue(callEpisodes);
    }
}

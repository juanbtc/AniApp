package org.jbtc.aniapp.ui.song;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.jbtc.aniapp.adapter.AnimeAdapter;
import org.jbtc.aniapp.adapter.SongAdapter;
import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.contract.SongService;
import org.jbtc.aniapp.databinding.FragmentSongBinding;
import org.jbtc.aniapp.model.RespuestaAnimes;
import org.jbtc.aniapp.model.RespuestaSongs;
import org.jbtc.aniapp.model.Song;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SongFragment extends Fragment {

    private FragmentSongBinding binding;
    private SongAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SongViewModel songViewModel =
                new ViewModelProvider(this).get(SongViewModel.class);

        binding = FragmentSongBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initAdapter();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aniapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SongService songService = retrofit.create(SongService.class);
        songService.getSongs().enqueue(new Callback<RespuestaSongs>() {
            @Override
            public void onResponse(Call<RespuestaSongs> call, Response<RespuestaSongs> response) {
                adapter.setItems(response.body().getData().getDocuments());
            }

            @Override
            public void onFailure(Call<RespuestaSongs> call, Throwable t) {
                Log.e("TAG", "onFailure: ", t);
            }
        });


    }

    private void initAdapter() {
        binding.rvSongList.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        binding.rvSongList.setLayoutManager(gridLayoutManager);
        adapter = new SongAdapter();
        binding.rvSongList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
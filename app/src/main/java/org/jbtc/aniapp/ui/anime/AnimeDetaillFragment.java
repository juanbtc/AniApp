package org.jbtc.aniapp.ui.anime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jbtc.aniapp.databinding.FragmentAnimeDetailBinding;

public class AnimeDetaillFragment extends Fragment {
    private FragmentAnimeDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAnimeDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle b = getArguments();
        if(b!=null){
            int id = b.getInt("id",0);
            //peti
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
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

import org.jbtc.aniapp.MainActivity;
import org.jbtc.aniapp.databinding.FragmentAnimeDetailsBinding;
import org.jbtc.aniapp.model.Anime;

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
            //peti
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }


}

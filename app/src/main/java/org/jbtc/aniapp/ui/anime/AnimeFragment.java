package org.jbtc.aniapp.ui.anime;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.databinding.FragmentAnimeBinding;


public class AnimeFragment extends Fragment {

    private FragmentAnimeBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("CiclosDeVidaF:","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("CiclosDeVidaF:","onCreate");
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("CiclosDeVidaF:","onCreateView");
        AnimeViewModel animeViewModel =
                new ViewModelProvider(this).get(AnimeViewModel.class);

        binding = FragmentAnimeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        //String texto = binding.button.getText().toString();






        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("CiclosDeVidaF:","onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("CiclosDeVidaF:","onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("CiclosDeVidaF:","onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("CiclosDeVidaF:","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("CiclosDeVidaF:","onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("CiclosDeVidaF:","onDestroyView");
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        Log.i("CiclosDeVidaF:","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("CiclosDeVidaF:","onDetach");
        super.onDetach();
    }
}
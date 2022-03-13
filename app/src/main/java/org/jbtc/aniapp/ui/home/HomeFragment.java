package org.jbtc.aniapp.ui.home;

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
import org.jbtc.aniapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private boolean lastFrag=false;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        if(lastFrag) {
            lastFrag=false;
            Toast.makeText(getContext(), "HomeFragment", Toast.LENGTH_SHORT).show();
        }
        //binding.button.setText("OK");
        //String texto = binding.button.getText().toString();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Bienvenido a home", Toast.LENGTH_LONG).show();
            }
        });


        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("StateFragment","onViewCreated:");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("StateFragment","onViewStateRestored:");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("StateFragment","onStart:");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("StateFragment","onResume:");
        lastFrag = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("StateFragment","onPause:");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("StateFragment","onStop:");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("StateFragment","onSaveInstanceState:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("StateFragment","onDestroy:");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
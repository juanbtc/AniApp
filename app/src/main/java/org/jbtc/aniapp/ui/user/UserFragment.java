package org.jbtc.aniapp.ui.user;

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
import org.jbtc.aniapp.adapter.UserAdapter;
import org.jbtc.aniapp.component.PaginationFragment;
import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.contract.UserService;
import org.jbtc.aniapp.databinding.FragmentUserBinding;
import org.jbtc.aniapp.model.RespuestaAnimes;
import org.jbtc.aniapp.model.RespuestaUser;
import org.jbtc.aniapp.model.RespuestaUsers;
import org.jbtc.aniapp.model.User;
import org.jbtc.aniapp.provider.AniApiProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserFragment  extends Fragment implements  PaginationFragment.OnClickCallback{
    FragmentUserBinding binding;
    private UserAdapter adapter;
    private int page=0;
    private int total_page=0;

    private Callback<RespuestaUsers> callUsers = new Callback<RespuestaUsers>() {
        @Override
        public void onResponse(Call<RespuestaUsers> call, Response<RespuestaUsers> response) {
            if(response.isSuccessful())
                adapter.setItems(response.body().getData().getDocuments());
            page = response.body().getData().getCurrent_page();
            total_page = response.body().getData().getLast_page();
            PaginationFragment paginationFragment = (PaginationFragment) getChildFragmentManager().findFragmentById(R.id.frag_user_pagination);
            paginationFragment.setEnumeration(page,total_page);
        }
        @Override
        public void onFailure(Call<RespuestaUsers> call, Throwable t) {
            Log.e("TAG", "onFailure: ", t);
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= FragmentUserBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initAdapter();
        PaginationFragment paginationFragment = (PaginationFragment) getChildFragmentManager().findFragmentById(R.id.frag_user_pagination);
        paginationFragment.setOnClickCallback(this);
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.aniapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);
        userService.getUsers().enqueue(new Callback<RespuestaUsers>() {
            @Override
            public void onResponse(Call<RespuestaUsers> call, Response<RespuestaUsers> response) {
                adapter.setItems(response.body().getData().getDocuments());
            }

            @Override
            public void onFailure(Call<RespuestaUsers> call, Throwable t) {
                Log.e("TAG", "onFailure: ", t);
            }
        });
      */
        UserService userService = AniApiProvider.getInstance().create(UserService.class);

        userService.getUsers(1).enqueue(callUsers);

    }

    private void initAdapter() {
        binding.rvUserList.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        binding.rvUserList.setLayoutManager(gridLayoutManager);
        adapter = new UserAdapter(getContext());
        binding.rvUserList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClickPagination(int page) {
        UserService userService = AniApiProvider.getInstance().create(UserService.class);
        userService.getUsers(page).enqueue(callUsers);
    }
}

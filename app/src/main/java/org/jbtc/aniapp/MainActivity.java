package org.jbtc.aniapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import org.jbtc.aniapp.contract.AnimeService;
import org.jbtc.aniapp.databinding.ActivityMainBinding;

import org.jbtc.aniapp.model.RespuestaAnimes;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "onCreate: ");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbarMain);
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Boton de funcion correo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_anime,
                R.id.nav_episode,
                R.id.nav_song,
                R.id.nav_user)

                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /*public void loadImgToolbar(String src_img) {
        Picasso.get()
                .load(src_img)
                .into(binding.appBarMain.ivCollToolCont);
    }*/

    public void setDisplayShowTitleEnabled(boolean enabled, boolean lockBar){
        try {
            CoordinatorLayout.LayoutParams params=null;
            if(lockBar)
                params = new CoordinatorLayout.LayoutParams(
                        CoordinatorLayout.LayoutParams.MATCH_PARENT,
                        CoordinatorLayout.LayoutParams.WRAP_CONTENT
                );
            else
                params = new CoordinatorLayout.LayoutParams(
                        CoordinatorLayout.LayoutParams.MATCH_PARENT,
                        getResources().getDimensionPixelSize(R.dimen.app_bar_height)
                );
            AppBarLayout appBar = findViewById(R.id.Appbar_layout_main);
            appBar.setLayoutParams(params);
            //binding.appBarMain.AppbarLayoutMain.setLayoutParams(params);


            binding.appBarMain.collToolbarLayoutMain.setTitleEnabled(enabled);
            /*siempre tiene anular la imagen por que cambia de pantalla*/
            binding.appBarMain.ivCollToolCont.setImageDrawable(null);
        }catch (Exception e){
            Log.e("TAG", "setDisplayShowTitleEnabled: ",e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy: ");
    }
}
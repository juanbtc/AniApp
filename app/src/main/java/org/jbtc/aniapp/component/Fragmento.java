package org.jbtc.aniapp.component;

import androidx.fragment.app.Fragment;

import org.jbtc.aniapp.MainActivity;
import org.jbtc.aniapp.R;
import org.jbtc.aniapp.model.Anime;
public class Fragmento extends Fragment {
    public MainActivity getMainActivity(){
        //if(getActivity() instanceof MainActivity)
        return ((MainActivity) getActivity());
    }
    public void updateIconFab(Anime anime){
        if(anime.isFavorite())
            getMainActivity().setFabImageResource(R.drawable.ic_favorite_white_24dp);
        else
            getMainActivity().setFabImageResource(R.drawable.ic_favorite_border_white_24dp);
    }


}
package org.jbtc.aniapp.component;

import androidx.fragment.app.Fragment;

import org.jbtc.aniapp.MainActivity;

public class Fragmento extends Fragment {
    public MainActivity getMainActivity(){
        //if(getActivity() instanceof MainActivity)
        return ((MainActivity) getActivity());
    }
}

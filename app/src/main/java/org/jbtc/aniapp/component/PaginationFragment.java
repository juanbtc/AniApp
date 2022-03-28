package org.jbtc.aniapp.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.databinding.FragmentPaginationBinding;

public class PaginationFragment extends Fragment {
    private FragmentPaginationBinding binding;

    private int page=0;
    private int total_pages=0;

    private OnClickCallback onClickCallback;
    public interface OnClickCallback{
        void onClickPagination(int page);
    }

    public void setOnClickCallback(OnClickCallback onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    private View.OnClickListener onClickTextView = view -> {
        TextView boton = (TextView) view;
        int page = Integer.valueOf( boton.getText().toString() );
        onClickCallback.onClickPagination(page);
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPaginationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvPaginationBt01.setOnClickListener(onClickTextView);
        binding.tvPaginationBt02.setOnClickListener(onClickTextView);
        binding.tvPaginationBt03.setOnClickListener(onClickTextView);
        binding.tvPaginationBt04.setOnClickListener(onClickTextView);
        binding.tvPaginationBt05.setOnClickListener(onClickTextView);
        binding.tvPaginationBt06.setOnClickListener(onClickTextView);
        binding.tvPaginationBt07.setOnClickListener(onClickTextView);
        binding.tvPaginationBt08.setOnClickListener(onClickTextView);
        binding.tvPaginationBt09.setOnClickListener(onClickTextView);
    }

    public void setEnumeration(int page,int total_pages){
        this.page = page;
        this.total_pages = total_pages;

        int i = page-2;
        int j = page+2;

        if(i<3){
            binding.tvPaginationBt03.setText("3");
            binding.tvPaginationBt04.setText("4");
            binding.tvPaginationBt05.setText("5");
            binding.tvPaginationBt06.setText("6");
            binding.tvPaginationBt07.setText("7");
        }else if(2<i && j<total_pages-2){
            binding.tvPaginationBt03.setText(String.valueOf(i));
            binding.tvPaginationBt04.setText(String.valueOf(i+1));
            binding.tvPaginationBt05.setText(String.valueOf(i+2));
            binding.tvPaginationBt06.setText(String.valueOf(i+3));
            binding.tvPaginationBt07.setText(String.valueOf(i+4));
        }else if(i<total_pages){
            binding.tvPaginationBt03.setText(String.valueOf(total_pages-6));
            binding.tvPaginationBt04.setText(String.valueOf(total_pages-5));
            binding.tvPaginationBt05.setText(String.valueOf(total_pages-4));
            binding.tvPaginationBt06.setText(String.valueOf(total_pages-3));
            binding.tvPaginationBt07.setText(String.valueOf(total_pages-2));
        }
        binding.tvPaginationBt08.setText(String.valueOf(total_pages-1));
        binding.tvPaginationBt09.setText(String.valueOf(total_pages));

        int n = binding.llPaginationContainer.getChildCount();
        for (int l=0;l<n;l++){
            TextView et = (TextView)binding.llPaginationContainer.getChildAt(l);
            if(String.valueOf(page).equals(et.getText().toString())){
                et.setBackgroundColor(getResources().getColor(R.color.teal_200));
            }else{
                et.setBackgroundTintList(null);
                et.setBackgroundColor(getResources().getColor(R.color.white));
                //et.setBackground(getResources().getDrawable(R.drawable.bg_btn_pagination));
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}

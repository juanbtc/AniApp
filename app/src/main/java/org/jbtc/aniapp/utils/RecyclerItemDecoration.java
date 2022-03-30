package org.jbtc.aniapp.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration{
    private int space;

    public RecyclerItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View card, RecyclerView parent, RecyclerView.State state) {
        int pos = parent.getChildLayoutPosition(card);
        int half_space= space/2;

        outRect.top = space;

        if(pos % 2 == 0){
            outRect.right = half_space;
            outRect.left = space;
        }else {
            outRect.right = space;
            outRect.left = half_space;
        }

        if(pos==parent.getLayoutManager().getItemCount()-2)
            outRect.bottom = space;
        if(pos==parent.getLayoutManager().getItemCount()-1)
            outRect.bottom = space;

    }
}

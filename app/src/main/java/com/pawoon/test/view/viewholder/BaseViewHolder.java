package com.pawoon.test.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pawoon.test.presenter.callback.RecyclerListener;


public class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    protected final RecyclerListener recyclerListener;

    public BaseViewHolder(View itemView, RecyclerListener recyclerListener) {
        super(itemView);
        this.recyclerListener = recyclerListener;

    }

    public void setData(T data) {
        itemView.setTag(data);
    }


    protected <K extends View> K findView(int id) {
        return (K) itemView.findViewById(id);
    }

}

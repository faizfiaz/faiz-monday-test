package com.project.base.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.base.R;
import com.project.base.presenter.callback.RecyclerListener;
import com.project.base.view.viewholder.VHEmpty;
import com.project.base.view.viewholder.VHLoad;

import java.util.ArrayList;


/**
 * Created by faizf on 11/21/2016.
 */

public class BaseAdapter<K> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final ArrayList<K> listItem;

    protected final int EMPTY = 0;
    protected final int NON_EMPTY = 1;
    protected final int LOAD_MORE = 2;
    protected final RecyclerListener recyclerListener;


    public BaseAdapter(ArrayList<K> listItem, RecyclerListener recyclerListener) {
        this.listItem = listItem;
        this.recyclerListener = recyclerListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EMPTY:
                return createEmptyHolder(parent);
            case NON_EMPTY:
                return createHolder(parent, viewType);
            case LOAD_MORE:
                return loadMore(parent);
        }
        return null;

    }

    private VHLoad loadMore(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.waiting_load_more, parent, false);
        return new VHLoad(view, recyclerListener);
    }

    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return null;
    }

    private RecyclerView.ViewHolder createEmptyHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_empty, parent, false);
        return new VHEmpty(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        if (listItem != null && listItem.size() > 0) {
            return listItem.size();
        } else {
            return 0;
        }
    }


    public ArrayList<K> getListItem() {
        return listItem;
    }

    @Override
    public int getItemViewType(int position) {
        if (listItem != null) {
            if (listItem.size() != 0) {
                if (listItem.get(listItem.size() - 1) != null)
                    return NON_EMPTY;
                else
                    return LOAD_MORE;
            } else {
                return EMPTY;
            }
        }
        return EMPTY;
    }


}

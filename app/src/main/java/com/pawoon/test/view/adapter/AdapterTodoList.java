package com.pawoon.test.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pawoon.test.R;
import com.pawoon.test.presenter.callback.RecyclerListener;
import com.pawoon.test.presenter.database.table.TodoListTable;
import com.pawoon.test.view.viewholder.VHTodoList;

import java.util.ArrayList;

/**
 * Created by faizf on 07/05/2018.
 */

public class AdapterTodoList extends BaseAdapter<TodoListTable> {

    private RecyclerListener recyclerListener;
    private ArrayList<TodoListTable> itemCopy;

    public AdapterTodoList(ArrayList<TodoListTable> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
        itemCopy = new ArrayList<>();
        itemCopy.addAll(listItem);
        this.recyclerListener = recyclerListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_list_todo, parent, false);
        VHTodoList holder = new VHTodoList(view, recyclerListener);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHTodoList && listItem != null && listItem.size() > 0) {
            ((VHTodoList) holder).setData(listItem.get(position));
        }
    }
}


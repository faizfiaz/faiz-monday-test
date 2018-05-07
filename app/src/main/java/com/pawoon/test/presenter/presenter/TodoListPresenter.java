package com.pawoon.test.presenter.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pawoon.test.presenter.callback.RecyclerListener;
import com.pawoon.test.presenter.contract.TodoListContract;
import com.pawoon.test.presenter.database.helper.TodoListHelper;
import com.pawoon.test.view.activity.TodoListActivity;
import com.pawoon.test.view.adapter.AdapterTodoList;

import org.androidannotations.annotations.EBean;

/**
 * Created by faizf on 07/05/2018.
 */
@EBean
public class TodoListPresenter extends BasePresenter<TodoListActivity> implements TodoListContract.Presenter, RecyclerListener {

    private TodoListHelper todoListHelper;

    @Override
    public void setList(RecyclerView list) {
        todoListHelper = new TodoListHelper(activity);
        list.setLayoutManager(new LinearLayoutManager(activity));
        list.setAdapter(new AdapterTodoList(todoListHelper.getAllTodoList(), this));
    }

    @Override
    public void onItemClick(Object o) {

    }

    @Override
    public void onItemClickWithCondition(Object o, boolean condition) {

    }

    @Override
    public void update(Object o, int amount) {

    }
}

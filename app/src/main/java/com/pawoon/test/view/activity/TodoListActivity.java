package com.pawoon.test.view.activity;

import android.support.v7.widget.RecyclerView;

import com.pawoon.test.R;
import com.pawoon.test.presenter.base.activity.BaseActivity;
import com.pawoon.test.presenter.contract.TodoListContract;
import com.pawoon.test.presenter.presenter.TodoListPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by faizf on 07/05/2018.
 */
@EActivity(R.layout.activity_todo_list)
public class TodoListActivity extends BaseActivity implements TodoListContract.View {

    @ViewById protected RecyclerView list;

    @Bean protected TodoListPresenter presenter;

    @AfterViews
    protected void init(){
        presenter.setViewAct(this);
        presenter.setList(list);
    }
}

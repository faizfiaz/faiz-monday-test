package com.pawoon.test.view.activity;

import com.pawoon.test.R;
import com.pawoon.test.presenter.base.activity.BaseActivity;
import com.pawoon.test.presenter.contract.MainContract;
import com.pawoon.test.presenter.presenter.MainPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainContract.View {

    @Bean protected MainPresenter presenter;

    @AfterViews
    protected void init(){
        presenter.setViewAct(this);

        //fetching data first
        presenter.getData();
    }

    @Click(R.id.todo_list)
    protected void todoList(){
        presenter.openTodoList();
    }
}

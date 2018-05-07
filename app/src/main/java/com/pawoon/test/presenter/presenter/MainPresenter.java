package com.pawoon.test.presenter.presenter;

import com.pawoon.test.model.entity.ModelTodoList;
import com.pawoon.test.presenter.contract.MainContract;
import com.pawoon.test.presenter.database.helper.TodoListHelper;
import com.pawoon.test.view.activity.MainActivity;
import com.pawoon.test.view.activity.TodoListActivity_;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by faizf on 07/05/2018.
 */
@EBean
public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {

    private TodoListHelper todoListHelper;

    @Override
    public void openTodoList() {
        TodoListActivity_.intent(activity).start();
    }

    @Override
    public void getData() {
        todoListHelper = new TodoListHelper(activity);
        if (todoListHelper.getTodoListCount() <= 0) {
            connectionGet.getTodoList(progress(), this);
        }
    }

    @Override
    public void onSuccess(Object o) {
        //retrieve data and save to db
        saveData((ArrayList<ModelTodoList>) o);
    }

    private void saveData(ArrayList<ModelTodoList> data) {
        todoListHelper.insertTodoList(data);
    }
}

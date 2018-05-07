package com.pawoon.test.presenter.contract;

import android.support.v7.widget.RecyclerView;

/**
 * Created by faizf on 07/05/2018.
 */

public class TodoListContract {

    public interface View{

    }

    public interface Presenter{
        void setList(RecyclerView list);
    }
}

package com.pawoon.test.presenter.contract;

/**
 * Created by faizf on 07/05/2018.
 */
//this class for contract between presenter and view
public class MainContract {

    public interface View{

    }

    public interface Presenter{
        void openTodoList();
        void getData();
    }

}

package com.pawoon.test.view.fragment;

import com.pawoon.test.R;
import com.pawoon.test.presenter.base.fragment.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by faizf on 3/30/2017.
 */
@EFragment (R.layout.fragment_home)
public class HomeFragment extends BaseFragment {

    @AfterViews
    protected void init(){

    }

    @Override
    public void backPressed() {

    }
}

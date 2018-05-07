package com.pawoon.test.presenter.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentManager;

import com.pawoon.test.R;
import com.pawoon.test.presenter.callback.CallbackConnection;
import com.pawoon.test.presenter.connection.get.ConnectionGet;
import com.pawoon.test.presenter.manager.DialogManager;
import com.pawoon.test.presenter.manager.IntentManager;
import com.pawoon.test.presenter.utils.FragmentManagerUtils;
import com.pawoon.test.presenter.utils.PermissionMarshmellow;
import com.pawoon.test.presenter.utils.UtilsLayout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by AndreHF on 3/28/2017.
 */

@EBean
public class BasePresenter<T> implements CallbackConnection {

    @RootContext protected Activity activity;

    @Bean protected IntentManager intentManager;

    @Setter protected T viewAct;

    @Bean protected UtilsLayout utilsLayout;

    @Getter
    @Bean protected FragmentManagerUtils fragmentManagerUtils;
    @Bean protected DialogManager dialogManager;
    @Bean protected PermissionMarshmellow permissionMarshmellow;
    @Bean protected ConnectionGet connectionGet;

    protected ProgressDialog progressDialog;

    @AfterInject
    protected void inject() {

    }

    public ProgressDialog progress(){
        progressDialog = new ProgressDialog(activity);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(activity.getResources().getString(R.string.content_progress));
        return progressDialog;
    }

    public void setFragmentManager(FragmentManager fragmentManager, String className) {
        fragmentManagerUtils.setFragmentManager(fragmentManager);
        fragmentManagerUtils.setCallback(this);
        fragmentManagerUtils.setClassName(className);
        dialogManager.setFragmentManager(fragmentManager);
    }

    public void setLayoutFragment(int layoutFragment) {
        fragmentManagerUtils.setLayoutFragment(layoutFragment);
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }
}

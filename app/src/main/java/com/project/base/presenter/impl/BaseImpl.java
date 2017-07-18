package com.project.base.presenter.impl;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.project.base.presenter.manager.DialogManager;
import com.project.base.presenter.manager.IntentManager;
import com.project.base.presenter.manager.ServiceManager;
import com.project.base.presenter.utils.FragmentManagerUtils;
import com.project.base.presenter.utils.PermissionMarshmellow;
import com.project.base.presenter.utils.UtilsLayout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.session.SessionUser;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by AndreHF on 3/28/2017.
 */

@EBean
public class BaseImpl<T> implements ConnectionListener {
    @RootContext
    protected Activity activity;

    @Bean
    protected IntentManager intentManager;

    @Setter
    protected T viewAct;
    @Bean
    protected UtilsLayout utilsLayout;
    @Bean
    protected ServiceManager serviceManager;
    @Getter
    @Bean
    protected FragmentManagerUtils fragmentManagerUtils;
    @Bean
    protected DialogManager dialogManager;
    @Bean
    protected PermissionMarshmellow permissionMarshmellow;


    @AfterInject
    protected void inject() {
        serviceManager.setConnectionListener(this);
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
    public void onSuccessWithData(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }

    @UiThread
    @Override
    public void onError(Object o) {
        dialogManager.errorDialog(String.valueOf(o));
    }

    @Override
    public void onMessageOnly(String message) {
        dialogManager.errorDialog(String.valueOf(message));
    }


    @Override
    public void unAuthorized() {
        new SessionUser(activity).clearUser();
    }

}

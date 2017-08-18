package com.project.base.presenter.connection.post;

import android.app.Activity;


import com.project.base.presenter.manager.IntentManager;
import com.project.base.presenter.utils.Util;
import com.project.base.presenter.utils.UtilsCodeCheck;
import com.project.base.presenter.utils.UtilsLayout;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by faizf on 3/30/2017.
 */
@EBean
public class ConnectionPost {

    @RootContext protected Activity activity;
    @Bean protected IntentManager intentManager;
    @Bean protected Util util;
    @Bean protected UtilsLayout utilsLayout;
    @Bean protected UtilsCodeCheck utilsCodeCheck;

//    public void goLogin(final ProgressDialog progressDialog, RequestLogin requestLogin, final CallbackConnection callbackConnection) {
//        progressDialog.show();
//        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
//        Call<ResponseLogin> loginCall = apiConfig.doLogin(requestLogin);
//        loginCall.enqueue(new Callback<ResponseLogin>() {
//            @Override
//            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
//                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseLogin> call, Throwable t) {
//                util.showDialogError(activity, t.getMessage());
//                progressDialog.dismiss();
//
//            }
//        });
//    }


}

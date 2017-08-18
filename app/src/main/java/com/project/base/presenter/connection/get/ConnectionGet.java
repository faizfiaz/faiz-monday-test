package com.project.base.presenter.connection.get;

import android.app.Activity;


import com.project.base.presenter.manager.IntentManager;
import com.project.base.presenter.utils.Util;
import com.project.base.presenter.utils.UtilsCodeCheck;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by faizf on 3/30/2017.
 */
@EBean
public class ConnectionGet {

    @RootContext protected Activity activity;

    @Bean protected UtilsCodeCheck utilsCodeCheck;
    @Bean protected IntentManager intentManager;
    @Bean protected Util util;


//    public void getHome(final ProgressDialog progressDialog, final CallbackConnection callbackConnection) {
//        progressDialog.show();
//        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
//        Call<ResponseHome> call = apiConfig.getHome();
//        call.enqueue(new Callback<ResponseHome>() {
//            @Override
//            public void onResponse(Call<ResponseHome> call, Response<ResponseHome> response) {
//                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseHome> call, Throwable t) {
//                util.showDialogError(activity, t.getMessage());
//                progressDialog.dismiss();
//            }
//        });
//    }
//
//
}

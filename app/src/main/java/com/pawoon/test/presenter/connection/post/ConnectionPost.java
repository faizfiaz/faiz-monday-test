package com.pawoon.test.presenter.connection.post;

import android.app.Activity;

import com.pawoon.test.presenter.manager.IntentManager;
import com.pawoon.test.presenter.utils.Util;
import com.pawoon.test.presenter.utils.UtilsCodeCheck;
import com.pawoon.test.presenter.utils.UtilsLayout;

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
//        final ApiEndpoint apiConfig = ApiClient.getClient(activity).create(ApiEndpoint.class);
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

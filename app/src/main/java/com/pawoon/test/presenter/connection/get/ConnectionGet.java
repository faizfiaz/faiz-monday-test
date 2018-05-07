package com.pawoon.test.presenter.connection.get;

import android.app.Activity;
import android.app.ProgressDialog;

import com.pawoon.test.model.entity.ModelTodoList;
import com.pawoon.test.presenter.callback.CallbackConnection;
import com.pawoon.test.presenter.connection.service.ApiClient;
import com.pawoon.test.presenter.connection.service.ApiEndpoint;
import com.pawoon.test.presenter.manager.IntentManager;
import com.pawoon.test.presenter.utils.Util;
import com.pawoon.test.presenter.utils.UtilsCodeCheck;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faizf on 3/30/2017.
 */
@EBean
public class ConnectionGet {

    @RootContext
    protected Activity activity;

    @Bean
    protected UtilsCodeCheck utilsCodeCheck;
    @Bean
    protected IntentManager intentManager;
    @Bean
    protected Util util;


    public void getTodoList(final ProgressDialog progressDialog, final CallbackConnection callbackConnection) {
        progressDialog.show();
        String url = "http://jsonplaceholder.typicode.com/todos";
        final ApiEndpoint endpoint = ApiClient.getClient(activity).create(ApiEndpoint.class);
        Call<ArrayList<ModelTodoList>> call = endpoint.doGetTodoList(url);
        call.enqueue(new Callback<ArrayList<ModelTodoList>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelTodoList>> call, Response<ArrayList<ModelTodoList>> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog);
            }
            @Override
            public void onFailure(Call<ArrayList<ModelTodoList>> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }
}

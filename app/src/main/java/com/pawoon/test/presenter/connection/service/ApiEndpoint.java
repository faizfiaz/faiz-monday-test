package com.pawoon.test.presenter.connection.service;

import com.pawoon.test.model.entity.ModelTodoList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by faizf on 2/8/2017.
 */

public interface ApiEndpoint {

    @GET
    Call<ArrayList<ModelTodoList>> doGetTodoList(@Url String url);
}

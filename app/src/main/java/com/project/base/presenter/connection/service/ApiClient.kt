package com.project.base.presenter.connection.service

import android.app.Activity


import com.project.base.BuildConfig
import com.project.base.presenter.base.session.SessionToken

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by faizf on 2/8/2017.
 */

class ApiClient : Activity() {
    companion object {

        val BASE_URL = BuildConfig.URL_BASE
        private var retrofit: Retrofit? = null


        fun getClient(activity: Activity): Retrofit {
            val token = SessionToken(activity)
            val interceptor = Interceptor { chain ->
                val request = chain.request().newBuilder()
                        .addHeader("X-AUTH-TOKEN", token.token)
                        .build()
                chain.proceed(request)
            }
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor)
            httpClient.connectTimeout(5, TimeUnit.MINUTES)
            httpClient.readTimeout(5, TimeUnit.MINUTES)
            val client = httpClient.build()

            val rxAdapter = RxJavaCallAdapterFactory.create()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(rxAdapter)
                        .client(client)
                        .build()
            }
            return retrofit
        }
    }
}

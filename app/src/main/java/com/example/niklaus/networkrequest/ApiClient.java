package com.example.niklaus.networkrequest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.niklaus.networkrequest.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by Niklaus on 2017/8/4.
 */

public class ApiClient {
    private static  ApiClient INSTANCE;
    private ApiService mApiService;
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private ApiClient(){

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BODY).setResponseBodyMaxLogBytes(5 * 8 * 1024))
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

    public static ApiClient getInstance(){
        if (INSTANCE == null){
            synchronized (ApiClient.class){
                if (INSTANCE == null){
                    INSTANCE = new ApiClient();
                }
            }
        }
        return INSTANCE;
    }

    public ApiService getApiService(){
        if(mApiService == null){
            mApiService = mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }
}

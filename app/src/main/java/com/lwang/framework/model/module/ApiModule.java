package com.lwang.framework.model.module;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lwang.framework.model.api.AppApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

@Module(includes = {AppModule.class, ClientModule.class})
public class ApiModule {

    // 自定义Gson对象设置统一日期请求格式,不需要手动去调整json里面的一些格式 ("yyyy-MM-dd'T'HH:mm:ssZ") 
    public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public AppApi provideApiFactory(Retrofit.Builder builder, OkHttpClient client) {
        return creatRetrofit(builder, AppApi.BASE_URL, client).create(AppApi.class);
    }


    private Retrofit creatRetrofit(Retrofit.Builder builder, String baseUrl, OkHttpClient client) {

        builder.baseUrl(baseUrl)
                .client(client) // 整合okHttp,如果不设置会提供一个默认的
                .addConverterFactory(GsonConverterFactory.create(gson)) // 添加Gson转换工厂
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()); // 添加RxJava调用适配工厂

        return builder.build();
    }


}

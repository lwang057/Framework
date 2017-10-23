package com.lwang.framework.model.module;


import com.lwang.framework.model.api.AppApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * ApiModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

@Module(includes = {AppModule.class, ClientModule.class})
public class ApiModule {


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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加RxJava2调用适配工厂
                .addConverterFactory(FastJsonConverterFactory.create()); // 添加FastJson转换工厂

        return builder.build();
    }


}

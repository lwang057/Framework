package com.lwang.framework.model.module;

import android.app.Application;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.lwang.framework.model.api.ApiUtil;
import com.lwang.framework.model.api.RequestInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * ClientModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Module
public class ClientModule {

    private static int TIME_OUT = 60_000;


    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }


    @Singleton
    @Provides
    List<Interceptor> provideInterceptors(Application context) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RequestInterceptor(context));
        interceptors.add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return interceptors;
    }


    @Singleton
    @Provides
    Interceptor provodeInterceptor() {
        return new StethoInterceptor();
    }


    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder,
                               Interceptor interceptor,
                               List<Interceptor> interceptors) {

        builder.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .addNetworkInterceptor(interceptor);

        for (Interceptor tempInterceptor : interceptors) {
            builder.addInterceptor(tempInterceptor);
        }

        return builder.build();
    }


}

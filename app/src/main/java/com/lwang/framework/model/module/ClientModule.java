package com.lwang.framework.model.module;

import android.app.Application;

import com.lwang.framework.model.ErrorListener;
import com.lwang.framework.model.HttpsUtils;
import com.lwang.framework.model.RxErrorHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * ClientModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Module
public class ClientModule {


    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }


    @Singleton
    @Provides
    public OkHttpClient provideClient(Application application,
                                      OkHttpClient.Builder builder,
                                      Interceptor interceptor,
                                      List<Interceptor> interceptors,
                                      HostnameVerifier hostnameVerifier) {

        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(interceptor)
                .hostnameVerifier(hostnameVerifier);

        for (Interceptor mInterceptor : interceptors) {
            builder.addInterceptor(mInterceptor);
        }

        return builder.build();
    }



//    @Singleton
//    @Provides
//    public List<Interceptor> provideInterceptors(Application context){
//
//        List<Interceptor> interceptors = new ArrayList<>();
//        interceptors.add();
//    }

    /**
     @Singleton
     @Provides
     List<Interceptor> provideInterceptors(Application context) {
     List<Interceptor> interceptors = new ArrayList<>();
     interceptors.add(new RequestInterceptor(context));
     interceptors.add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
     return interceptors;
     }

     @Singleton
     @Provides       //network拦截器
     Interceptor provodeInterceptor(){
     return new StethoInterceptor();
     }
     * @return
     */

    @Singleton
    @Provides
    public HostnameVerifier provideHostnameVerifier(){
        return new HttpsUtils.UnSafeHostnameVerifier();
    }

    @Provides
    public ErrorListener provideErrorHandler() {
        return new RxErrorHandler();
    }

}

package com.lwang.framework.model.module;

import com.lwang.framework.app.MyApplication;
import com.lwang.framework.model.api.RequestInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
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

    private static final String RETROFIT_CACHE_FILE_NAME = "retrofit";


    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public Interceptor provideInterceptor() {
        return new RequestInterceptor();
    }


    @Singleton
    @Provides
    public OkHttpClient provideClient(OkHttpClient.Builder builder, Interceptor interceptor) {

        builder.cache(new Cache(new File(MyApplication.getInstance().getCacheDir(), RETROFIT_CACHE_FILE_NAME), 10 * 1024 * 1024)) // 设置缓存路径和大小
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        return builder.build();
    }


}

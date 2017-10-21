package com.lwang.framework.model.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    public Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }


//    @Provides
//    public AppApi provideApiFactory(){
//
//        return AppApi;
//    }


}

package com.lwang.framework.model.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    public Application provideApplication() {
        return mApplication;
    }

}

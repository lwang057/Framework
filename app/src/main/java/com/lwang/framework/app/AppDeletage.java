package com.lwang.framework.app;

import android.app.Application;

import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.model.component.AppComponent;
import com.lwang.framework.model.component.DaggerApiComponent;
import com.lwang.framework.model.component.DaggerAppComponent;
import com.lwang.framework.model.module.ApiModule;
import com.lwang.framework.model.module.AppModule;

/**
 * AppDeletage.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public class AppDeletage {

    private Application appContext;
    private ApiComponent apiComponent;
    private AppComponent appComponent;

    public AppDeletage(Application application) {
        this.appContext = application;
    }


    public void onCreate(){
        initInject();
    }

    private void initInject(){

        appComponent = DaggerAppComponent.builder()
                .appModule(getAppModule())
                .build();

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .appModule(getAppModule())
                .build();
    }


    private AppModule getAppModule() {
        return new AppModule(appContext);
    }


    public ApiComponent getApiComponent(){
        return apiComponent;
    }


    public void onTerminate(){
        this.apiComponent = null;
        this.appComponent = null;
    }

}

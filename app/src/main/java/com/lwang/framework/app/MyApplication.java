package com.lwang.framework.app;

import android.app.Application;

import com.lwang.framework.model.component.ApiComponent;

/**
 * MyApplication.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public class MyApplication extends Application {

    private AppDeletage appDeletage;

    @Override
    public void onCreate() {
        super.onCreate();

        appDeletage = new AppDeletage(this);
        appDeletage.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        // 程序在内存清理的时候执行
        appDeletage.onTerminate();
    }

    public ApiComponent getApiComponent(){
        return appDeletage.getApiComponent();
    }


}

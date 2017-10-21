package com.lwang.framework.model.module;

import com.lwang.framework.model.ErrorListener;
import com.lwang.framework.model.RxErrorHandler;

import dagger.Module;
import dagger.Provides;

/**
 * ClientModule.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Module
public class ClientModule {

    @Provides
    public ErrorListener provideErrorHandler(){
        return new RxErrorHandler();
    }

}

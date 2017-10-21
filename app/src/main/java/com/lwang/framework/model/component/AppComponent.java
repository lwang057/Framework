package com.lwang.framework.model.component;

import com.lwang.framework.app.AppDeletage;
import com.lwang.framework.model.module.AppModule;

import dagger.Component;

/**
 * AppComponent.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(AppDeletage appDeletage);
}

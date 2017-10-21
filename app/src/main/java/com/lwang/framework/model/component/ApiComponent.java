package com.lwang.framework.model.component;

import com.lwang.framework.model.module.ApiModule;
import com.lwang.framework.ui.activity.MainActivity;
import com.lwang.framework.ui.activity.TestActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApiComponent.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);

    void inject(TestActivity testActivity);
}

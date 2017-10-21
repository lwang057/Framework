package com.lwang.framework.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.lwang.framework.R;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.MainActivityPresenter;
import com.lwang.framework.ui.base.BaseActivity;
import com.lwang.framework.ui.base.IBaseView;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/10/20.
 */
public class MainActivity extends BaseActivity<MainActivityPresenter> implements IBaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    public void button(View view) {

        mPresenter.requestData();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


}

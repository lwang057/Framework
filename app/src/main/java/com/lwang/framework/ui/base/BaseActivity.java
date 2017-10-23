package com.lwang.framework.ui.base;

import android.content.Context;
import android.os.Bundle;

import com.lwang.framework.app.MyApplication;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.BasePresenter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity.class
 *
 * @author lwang
 * @date 2017/10/20.
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements IBaseView {

    @Inject
    protected T mPresenter;

    protected Context context;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this;
        inject(((MyApplication) getApplication()).getApiComponent());

        mPresenter.attachView(this);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
    }


}

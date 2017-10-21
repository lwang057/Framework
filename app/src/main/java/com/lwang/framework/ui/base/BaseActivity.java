package com.lwang.framework.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lwang.framework.app.MyApplication;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.base.BasePresenter;
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
        inject(((MyApplication)getApplication()).getApiComponent());

        mPresenter.attachView(this);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

        // 此方法是给Presenter 传递当前Activety的上下文 必须写在getData前面
        mPresenter.getContext(context);
        mPresenter.getData(getIntent());
    }

    protected abstract void inject(ApiComponent apiComponent);
    protected abstract int getLayoutId();

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onTakeView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, requestCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
    }


}

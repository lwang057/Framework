package com.lwang.framework.ui.activity;

import android.view.View;
import android.widget.Button;

import com.lwang.framework.R;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.MainActivityPresenter;
import com.lwang.framework.presenter.base.AppContract;
import com.lwang.framework.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/10/20.
 */
public class MainActivity extends BaseActivity<MainActivityPresenter> implements AppContract.MainActivityView {

    @BindView(R.id.btn)
    Button button;

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.requestData();
            }
        });
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void showResult() {

    }


}

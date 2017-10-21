package com.lwang.framework.ui.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lwang.framework.R;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.TestActivityPresenter;
import com.lwang.framework.presenter.base.AppContract;
import com.lwang.framework.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * TestActivity.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
public class TestActivity extends BaseActivity<TestActivityPresenter> implements AppContract.TestActivityView {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        tv.setOnClickListener(new View.OnClickListener() {
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

        Toast.makeText(this, "TestActivity", Toast.LENGTH_SHORT).show();
    }


}

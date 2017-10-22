package com.lwang.framework.ui.activity;

import android.widget.TextView;
import android.widget.Toast;

import com.lwang.framework.R;
import com.lwang.framework.model.api.AppApi;
import com.lwang.framework.model.bean.Result;
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
        tv.setOnClickListener(v -> mPresenter.requestData("18137783319", AppApi.KEY));
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult(Result result) {

        String city = result.getCity();
        Toast.makeText(this, "TestActivity" + city, Toast.LENGTH_SHORT).show();
    }


}

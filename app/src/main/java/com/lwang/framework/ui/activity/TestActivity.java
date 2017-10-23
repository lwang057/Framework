package com.lwang.framework.ui.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lwang.framework.R;
import com.lwang.framework.model.bean.LocationBean;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.TestActivityPresenter;
import com.lwang.framework.ui.base.AppContract;
import com.lwang.framework.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * TestActivity.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
public class TestActivity extends BaseActivity<TestActivityPresenter> implements AppContract.TestActivityView {

    @BindView(R.id.edt)
    EditText edt;
    @BindView(R.id.btn)
    Button button;

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

        button.setOnClickListener(v -> {

            String phone = edt.getText().toString().trim();
            if (!phone.matches("^1[34578][0-9]{9}$")) {
                edt.setText("");
                edt.setHint("请输入正确的手机号");
                return;
            }

            mPresenter.requestData(phone);
        });
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult(LocationBean locationBean) {

        String province = locationBean.result.province;
        String city = locationBean.result.city;
        String company = locationBean.result.company;

        Toast.makeText(context, province + city + ":" + company, Toast.LENGTH_SHORT).show();
    }


}

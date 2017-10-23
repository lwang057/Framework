package com.lwang.framework.presenter;

import android.content.Intent;
import android.util.Log;

import com.lwang.framework.model.api.ApiUtil;
import com.lwang.framework.model.api.AppApi;
import com.lwang.framework.model.bean.Result;
import com.lwang.framework.presenter.base.AppContract;
import com.lwang.framework.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * TestActivityPresenter.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public class TestActivityPresenter extends BasePresenter<AppContract.TestActivityView> {

    private AppApi appApi;

    @Inject
    public TestActivityPresenter(AppApi appApi) {
        this.appApi = appApi;
    }

    public void requestData(String phone) {

        Log.i("wang", "phone:::" + phone);

        mView.showLoading();
        appApi.getLocation(phone, AppApi.KEY)
                .compose(ApiUtil.bindToLifecycle(mView))
                .compose(ApiUtil.genTransformer())
                .subscribe((Result result) -> {

                    mView.hideLoading();
                    mView.showResult(result);
                }, ApiUtil::doOnError);
    }



    @Override
    public void getData(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int requestCode1, Intent data) {


    }


}

package com.lwang.framework.presenter;

import android.util.Log;


import com.lwang.framework.model.api.ApiUtil;
import com.lwang.framework.model.api.AppApi;
import com.lwang.framework.model.api.RequestCallback;
import com.lwang.framework.model.bean.LocationBean;
import com.lwang.framework.ui.base.AppContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;


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

        mView.showLoading();
        appApi.getLocation(phone, AppApi.KEY)
                .compose(ApiUtil.<LocationBean>getSchedulerTransformer())
                .subscribe(new RequestCallback<LocationBean>() {
                    @Override
                    public void onNext(@NonNull LocationBean locationBean) {
                        super.onNext(locationBean);
                        mView.hideLoading();
                        mView.showResult(locationBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        mView.hideLoading();

                        Log.i("wang", e + "");
                    }
                });
    }

}

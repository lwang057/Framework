package com.lwang.framework.presenter;

import android.content.Intent;

import com.lwang.framework.presenter.base.AppContract;
import com.lwang.framework.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * MainActivityPresenter.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public class MainActivityPresenter extends BasePresenter<AppContract.MainActivityView> {

    @Inject
    public MainActivityPresenter() {
    }

    public void requestData() {

        mView.showLoading();
        mView.hideLoading();
        mView.showResult();
    };


    @Override
    public void getData(Intent intent) {


    }

    @Override
    public void onActivityResult(int requestCode, int requestCode1, Intent data) {


    }

}

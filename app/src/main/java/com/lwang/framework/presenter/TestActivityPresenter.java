package com.lwang.framework.presenter;

import android.content.Intent;

import com.lwang.framework.model.ErrorListener;
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

    @Inject
    public TestActivityPresenter(ErrorListener errorListener) {
        super(errorListener);
    }

    public void requestData(){

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

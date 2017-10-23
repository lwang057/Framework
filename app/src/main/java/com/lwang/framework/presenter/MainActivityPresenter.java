package com.lwang.framework.presenter;


import com.lwang.framework.ui.base.AppContract;

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

}

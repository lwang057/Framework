package com.lwang.framework.presenter;


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

}

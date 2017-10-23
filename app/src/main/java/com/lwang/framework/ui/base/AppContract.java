package com.lwang.framework.ui.base;

import com.lwang.framework.model.bean.LocationBean;

/**
 * AppContract.class
 *
 * @author lwang
 * @date 2017/10/23.
 */
public interface AppContract {

    interface MainActivityView extends IBaseView {
        void showResult();
    }


    interface TestActivityView extends IBaseView {
        void showResult(LocationBean locationBean);
    }
}

package com.lwang.framework.presenter.base;

import com.lwang.framework.ui.base.IBaseView;

/**
 * AppContract.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
public interface AppContract {

    interface MainActivityView extends IBaseView{
        void showResult();
    }


    interface TestActivityView extends IBaseView{
        void showResult();
    }

}

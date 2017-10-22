package com.lwang.framework.presenter.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lwang.framework.ui.base.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


/**
 * BasePresenter.class
 *
 * @author lwang
 * @date 2017/10/21.
 */
public class BasePresenter<View extends IBaseView> {

    protected Context context;
    protected View mView;
    protected Reference<View> reference;
    private boolean isViewAttach;

    public BasePresenter() {
    }

    public void attachView(View view) {

        // 使用弱引用得到view，可以及时回收
        reference = new WeakReference<>(view);
        mView = reference.get();
    }


    public void detachView() {
        if (reference != null) {
            reference.clear();
        }
        reference = null;
    }


    public void getContext(Context context){
        this.context = context;
    }


    /**
     * 页面跳转可以携带数据过来
     * @param intent
     */
    public void getData(Intent intent){

    }


    /**
     * 页面跳转 数据回传 Presenter写此方法拿回传数据
     * @param requestCode
     * @param requestCode1
     * @param data
     */
    public void onActivityResult(int requestCode, int requestCode1, Intent data){

    }


    /**
     * 如果需要进来就要联网请求数据，Presenter 中覆写此方法
     */
    public void onTakeView(){
        if(!isViewAttach){
            isViewAttach = true;
            onOnceTakeView();
        }
    }

    /**
     * 如果只需要第一次加载页面联网请求数据，Presenter 中覆写次方法
     */
    private void onOnceTakeView() {

    }

    public void getArguments(Bundle bundle){

    }

    public void onHiddenChanged(boolean hidden){

    }

}

package com.lwang.framework.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwang.framework.app.MyApplication;
import com.lwang.framework.model.component.ApiComponent;
import com.lwang.framework.presenter.BasePresenter;
import com.trello.rxlifecycle.components.support.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment.class
 *
 * @author lwang
 * @date 2017/10/20.
 */
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment implements IBaseView {

    @Inject
    protected T mPresenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject(((MyApplication) getActivity().getApplication()).getApiComponent());

        mPresenter.attachView(this);
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
    }


}

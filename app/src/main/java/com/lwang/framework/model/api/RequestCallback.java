package com.lwang.framework.model.api;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * RequestCallback.class
 *
 * @author lwang
 * @date 2017/10/23.
 */
public class RequestCallback<T> implements Observer<T> {


    public RequestCallback() {
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
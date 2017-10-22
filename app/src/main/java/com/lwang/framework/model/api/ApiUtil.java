package com.lwang.framework.model.api;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.lwang.framework.app.MyApplication;
import com.lwang.framework.ui.base.IBaseView;
import com.lwang.framework.utils.L;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.BuildConfig;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.NoSuchElementException;

import retrofit2.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * ApiUtil.class
 *
 * @author lwang
 * @date 2017/10/22.
 */

public class ApiUtil {


    /**
     * 在presenter中使用生命周期管理，防止内存泄漏
     */
    public static <T> LifecycleTransformer<T> bindToLifecycle(IBaseView view) {

        if (view instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity) view).bindToLifecycle();
        } else if (view instanceof RxFragment) {
            return ((RxFragment) view).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }
    }

    /**
     * Transformer转换器的意思，将联网的响应做统一的预处理
     */
    public static <T> Observable.Transformer<ServerResponse<T>, T> genTransformer() {

        return observable ->
                observable.flatMap(ApiUtil::unpack)
                        .doOnNext(result -> {
                            if (BuildConfig.DEBUG) L.json(result);
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }


    public static <T> Observable<T> unpack(final ServerResponse<T> result) {

        return Observable.create(
                subscriber -> {

                    int code = Integer.parseInt(result.getResultcode());
                    Log.i("wang", "code:::::::::" + code);

                    switch (code) {
                        case 200:
                            subscriber.onNext(result.getResult());
                            break;
                        default:
                            throw new ServerException(code, result.getReason());
                    }
                    subscriber.onCompleted();
                }
        );
    }


    public static void doOnError(Throwable throwable) {

        if (throwable instanceof NoSuchElementException) return;


        if (throwable instanceof HttpException) {

            HttpException exception = (HttpException) throwable;
            int code = exception.response().code();
            Log.i("wang", "code:::::::::" + code);

            Toast.makeText(MyApplication.getInstance(), "请检查您的网络连接后重试。", Toast.LENGTH_SHORT).show();
            return;
        }

        if (throwable instanceof ServerException) {
            if (!TextUtils.isEmpty(throwable.getMessage())) {
                Toast.makeText(MyApplication.getInstance(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}

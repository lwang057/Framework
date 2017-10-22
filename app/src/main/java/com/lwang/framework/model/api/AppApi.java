package com.lwang.framework.model.api;

import com.lwang.framework.model.bean.Result;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * AppApi.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public interface AppApi {

    String BASE_URL = "http://apis.juhe.cn/";
    String KEY = "daf8fa858c330b22e342c882bcbac622";

    // 手机归属地查询          http://apis.juhe.cn/mobile/get?phone=18137783319&key=daf8fa858c330b22e342c882bcbac622
    @GET("mobile/get")
    Observable<ServerResponse<Result>> getLocation(@Query("phone") String phoneNumber, @Query("key") String key);
}

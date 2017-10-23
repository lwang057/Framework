package com.lwang.framework.model.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * RequestInterceptor.class
 *
 * @author lwang
 * @date 2017/10/22.
 * <p>
 * 对每个请求添加请求头
 */

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        // 这个chain里面包含了request和response，所以要什么都可以从这里拿
        Request request1 = chain.request();


        Log.i("wang", String.format("发送请求: [%s] %s%n%s",
                request1.url(), chain.connection(), request1.headers()));

        Response response = chain.proceed(request1);
        Log.i("wang", "response::::::::::::::::::" + response);

        Log.i("wang", String.format("接收响应: [%s] %.1fms%n%s",
                response.request().url(), 1e6d, response.headers()));

        // 给每个请求添加请求头
//        Request.Builder builder = request1.newBuilder();
//                .addHeader("version", Utils.getVersionName())
//                .addHeader("timestamp", DateUtils.getTime())
//                .addHeader("platform", Constants.ANDROID)
//                .addHeader("token", Constants.TOKEN);

//        Request request = builder.build();
        return response;
    }

}

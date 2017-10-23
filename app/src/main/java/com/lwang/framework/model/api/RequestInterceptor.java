package com.lwang.framework.model.api;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    private final int DEVICE_TYPE = 1; // 设备类型
    private Context context;


    public RequestInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("data", fetchHeaderInfo())
                .method(original.method(), original.body());

        return chain.proceed(requestBuilder.build());
    }


    private String fetchHeaderInfo() {

        Map<String, String> map = new HashMap<>();
        map.put("DeviceType", String.valueOf(DEVICE_TYPE));
        JSONObject json = new JSONObject(map);

        return json.toString();
    }

}

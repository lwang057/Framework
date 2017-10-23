package com.lwang.framework.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ApiUtil.class
 *
 * @author lwang
 * @date 2017/10/23.
 */
public class LocationBean {

    @JSONField(name = "resultcode")
    public String resultcode;
    @JSONField(name = "reason")
    public String reason;
    @JSONField(name = "result")
    public Result result;
    @JSONField(name = "error_code")
    public Integer errorCode;
}

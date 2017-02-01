package com.nefu.software.tpa.entity.enums;

/**
 * 返回结果状态的枚举类型
 *
 * Created by Super腾 on 2017/1/22.
 */
public enum ResultStatus {
    PERSON(0,"SUCCESSFUL RELIEFPERSON"), //扶贫用户成功
    COMPANY(1,"SUCCESSFUL RELIEFCOMPANY"), //扶贫单位成功
    SUCCESSFUL(2,"SUCCESSFUL"),//返回成功的标示
    FAILURE(3,"VERIFY CODE WAS WRONG"), //验证码错误
    NOTFOUND(4,"USER NOT FOUND"), //用户名或密码错误
    MISSING(5,"MISSING PARAM"); //缺少需要的参数
    public Integer code;
    public String message;
    private Object object;
    private  ResultStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}

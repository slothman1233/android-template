package com.cjjc.lib_login.common.api;

public class ApiLogin {

    //注册
    public static final String REGISTER="auth/register";
    //密码登录
    public static final String LOGIN_PWD ="auth/login";
    //验证码登录
    public static final String LOGIN_CODE ="auth/smsLogin";
    //发送验证码
    public static final String SEND_SMS_CODE="auth/smsCodeSend";
    //忘记密码
    public static final String FORGET_PWD="auth/resetLoginPwd";

}

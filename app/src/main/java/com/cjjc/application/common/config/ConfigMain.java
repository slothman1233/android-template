package com.cjjc.application.common.config;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import com.cjjc.lib_public.common.router.auth.AuthLoginMag;
import com.cjjc.application.common.serve.BusinessServeInject;

/**
 * 主工程配置
 */
public class ConfigMain {
    private static ConfigMain instance;
    private static ConfigMainInfo configMainInfo;//主工程配置信息

    //总业务服务注入对象
    private BusinessServeInject businessServeInject=BusinessServeInject.getInstance();


    private ConfigMain(){
        ARouter.getInstance().inject(this);
        configMainInfo=ConfigMainInfo.getInstance();
    }

    public static ConfigMain getInstance() {
        if (instance == null) {
            synchronized (ConfigMain.class) {
                if (instance == null) {
                    instance = new ConfigMain();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context){
        configMainInfo.init(context);
        //添加Home模块登录鉴权码
        AuthLoginMag.getInstance().addAuthCode(businessServeInject.getServeHomeGetData().getAuthCodeToLogin());
        AuthLoginMag.getInstance().addAuthCode(businessServeInject.getServeMeGetData().getAuthCodeToLogin());
    }

    /**
     * 主工程配置信息
     * @return
     */
    public static ConfigMainInfo getConfigMainInfo() {
        return configMainInfo;
    }
}

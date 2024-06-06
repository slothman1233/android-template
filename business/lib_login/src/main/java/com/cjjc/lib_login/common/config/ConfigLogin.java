package com.cjjc.lib_login.common.config;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Login工程配置
 */
public class ConfigLogin {
    private static ConfigLogin instance;
    private ConfigLoginInfo configLoginInfo; //Login工程配置信息

    private ConfigLogin() {
        ARouter.getInstance().inject(this);
        configLoginInfo=ConfigLoginInfo.getInstance();
    }

    public static ConfigLogin getInstance() {
        if (instance == null) {
            synchronized (ConfigLogin.class) {
                if (instance == null) {
                    instance = new ConfigLogin();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        configLoginInfo.init(context);
    }

    /**
     * Login工程配置信息
     *
     * @return
     */
    public ConfigLoginInfo getConfigHomeInfo() {
        return configLoginInfo;
    }
}

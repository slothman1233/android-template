package com.cjjc.lib_home.common.config;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Home工程配置
 */
public class ConfigHome {
    private static ConfigHome instance;
    private ConfigHomeInfo configHomeInfo; //Home工程配置信息

    private ConfigHome() {
        ARouter.getInstance().inject(this);
        configHomeInfo=ConfigHomeInfo.getInstance();
    }

    public static ConfigHome getInstance() {
        if (instance == null) {
            synchronized (ConfigHome.class) {
                if (instance == null) {
                    instance = new ConfigHome();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        configHomeInfo.init(context);
    }

    /**
     * Home工程配置信息
     *
     * @return
     */
    public ConfigHomeInfo getConfigHomeInfo() {
        return configHomeInfo;
    }
}

package com.cjjc.lib_me.common.config;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_public.common.config.ConfigPublic;
import com.cjjc.lib_public.common.config.ConfigPublicInfo;

/**
 * Me工程配置
 */
public class ConfigMe {
    private static ConfigMe instance;
    private ConfigMeInfo configMeInfo;//Me工程配置信息

    private ConfigMe() {
        ARouter.getInstance().inject(this);
        configMeInfo = ConfigMeInfo.getInstance();
    }

    public static ConfigMe getInstance() {
        if (instance == null) {
            synchronized (ConfigMe.class) {
                if (instance == null) {
                    instance = new ConfigMe();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        configMeInfo.init(context);
    }

    /**
     * Me工程配置信息
     *
     * @return
     */
    public ConfigMeInfo getConfigMeInfo() {
        return configMeInfo;
    }
}

package com.cjjc.lib_public.common.config;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 公共工程配置
 */
public class ConfigPublic {
    private static ConfigPublic instance;
    private ConfigPublicInfo configInfo; //公共工程配置信息

    private ConfigPublic(){
        ARouter.getInstance().inject(this);
        configInfo = ConfigPublicInfo.getInstance();
    }

    public static ConfigPublic getInstance() {
        if (instance == null) {
            synchronized (ConfigPublic.class) {
                if (instance == null) {
                    instance = new ConfigPublic();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context){
        configInfo.init(context);
    }

    /**
     * 公共配置详情
     * @return
     */
    public ConfigPublicInfo getConfigInfo() {
        return configInfo;
    }
}

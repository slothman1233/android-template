package com.cjjc.lib_login.common.config;

import android.content.Context;

public class ConfigLoginInfo {

    private static ConfigLoginInfo instance;

    protected static ConfigLoginInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigLoginInfo.class) {
                if (instance == null) {
                    instance = new ConfigLoginInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context){}

}

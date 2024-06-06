package com.cjjc.lib_me.common.config;

import android.content.Context;

public class ConfigMeInfo {

    private static ConfigMeInfo instance;

    protected static ConfigMeInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigMeInfo.class) {
                if (instance == null) {
                    instance = new ConfigMeInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context){}

}

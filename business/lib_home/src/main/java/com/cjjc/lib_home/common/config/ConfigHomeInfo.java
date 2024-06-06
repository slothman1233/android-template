package com.cjjc.lib_home.common.config;

import android.content.Context;

public class ConfigHomeInfo {

    private static ConfigHomeInfo instance;

    protected static ConfigHomeInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigHomeInfo.class) {
                if (instance == null) {
                    instance = new ConfigHomeInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context){}

}

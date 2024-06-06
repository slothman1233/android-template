package com.cjjc.application.common.config;

import android.content.Context;

public class ConfigMainInfo {

    private static ConfigMainInfo instance;

    protected static ConfigMainInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigMainInfo.class) {
                if (instance == null) {
                    instance = new ConfigMainInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context){}

}

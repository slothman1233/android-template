package com.cjjc.cjjc_business_cjjc.common.config;

import android.content.Context;

public class Configcjjc_busines_titlecase_cjjcInfo {

    private static Configcjjc_busines_titlecase_cjjcInfo instance;

    protected static Configcjjc_busines_titlecase_cjjcInfo getInstance() {
        if (instance == null) {
            synchronized (Configcjjc_busines_titlecase_cjjcInfo.class) {
                if (instance == null) {
                    instance = new Configcjjc_busines_titlecase_cjjcInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context){}

}

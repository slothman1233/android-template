package com.cjjc.cjjc_business_cjjc.common.config;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * cjjc_busines_titlecase_cjjc工程配置
 */
public class Configcjjc_busines_titlecase_cjjc {
    private static Configcjjc_busines_titlecase_cjjc instance;
    private Configcjjc_busines_titlecase_cjjcInfo configcjjc_busines_titlecase_cjjcInfo; //cjjc_busines_titlecase_cjjc工程配置信息

    private Configcjjc_busines_titlecase_cjjc() {
        ARouter.getInstance().inject(this);
        configcjjc_busines_titlecase_cjjcInfo=Configcjjc_busines_titlecase_cjjcInfo.getInstance();
    }

    public static Configcjjc_busines_titlecase_cjjc getInstance() {
        if (instance == null) {
            synchronized (Configcjjc_busines_titlecase_cjjc.class) {
                if (instance == null) {
                    instance = new Configcjjc_busines_titlecase_cjjc();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        configcjjc_busines_titlecase_cjjcInfo.init(context);
    }

    /**
     * cjjc_busines_titlecase_cjjc工程配置信息
     *
     * @return
     */
    public Configcjjc_busines_titlecase_cjjcInfo getConfigcjjc_busines_titlecase_cjjcInfo() {
        return configcjjc_busines_titlecase_cjjcInfo;
    }
}

package com.cjjc.application.page.splash;

import com.cjjc.application.common.api.ApiMain;
import com.cjjc.lib_base_view.view.BaseModel;
import com.cjjc.lib_network.base_net.NetSingleCallBackImpl;
import com.cjjc.lib_public.common.bean.PublicConfigBean;

import javax.inject.Inject;

/**
 * 数据获取实现层->Splash
 */
public class SplashModel extends BaseModel implements SplashInterface.Model {

    @Inject
    public SplashModel() {
    }


    @Override
    public void getPublicConfig(NetSingleCallBackImpl<PublicConfigBean> callBack) {
        app.getIHttp().httpGet(activity, ApiMain.PUBLIC_CONFIG,callBack);
    }
}

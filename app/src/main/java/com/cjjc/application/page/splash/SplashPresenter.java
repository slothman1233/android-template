package com.cjjc.application.page.splash;


import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;
import com.cjjc.lib_network.base_net.NetSingleCallBackImpl;
import com.cjjc.lib_public.common.bean.PublicConfigBean;
import com.cjjc.lib_public.common.config.ConfigPublic;

import javax.inject.Inject;

/**
 * 业务调度控制器->Splash
 */
public class SplashPresenter extends BaseActivityPresenter<SplashInterface.Model, SplashInterface.View> implements SplashInterface.Presenter{

    //初始化时注入M层
    @Inject
    public SplashPresenter(SplashInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

    @Override
    public void getPublicConfig() {
        mModel.getPublicConfig(new NetSingleCallBackImpl<PublicConfigBean>() {
            @Override
            public void onSuccess(PublicConfigBean response, int code, String msg) {
                ConfigPublic.getInstance().getConfigInfo().setPublicConfig(response);
                mView.getPublicConfig();
            }

            @Override
            public void onError(String msg, int code) {
                mView.getPublicConfig();
            }
        });
    }

}

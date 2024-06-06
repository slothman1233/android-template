package com.cjjc.application.page.splash;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;
import com.cjjc.lib_network.base_net.NetSingleCallBackImpl;
import com.cjjc.lib_public.common.bean.PublicConfigBean;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * 业务接口声明->Splash
 */
public interface SplashInterface {
    /**
     * View层接口定义
     */
    interface View extends IViewInterface {
        void getPublicConfig();
    }

    /**
     * Model层接口定义
     */
    interface Model extends IModelInterface {
        void getPublicConfig(NetSingleCallBackImpl<PublicConfigBean> callBack);
    }

    /**
     * Presenter层接口定义
     */
    interface Presenter extends IPresenterInterface {
        void getPublicConfig();
    }
}


/**
 * M层注入方式声明
 */
@InstallIn(ActivityComponent.class)
@Module
abstract class SplashProvides {

    @Binds
    abstract SplashInterface.Model provideModel(SplashModel splashModel);

}


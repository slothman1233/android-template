package com.cjjc.lib_login.page.login;


import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * 业务接口声明->Login
 */
public interface LoginInterface {
    /**
     * View层接口定义
     */
    interface View extends IViewInterface {
    }

    /**
     * Model层接口定义
     */
    interface Model extends IModelInterface {
    }

    /**
     * Presenter层接口定义
     */
    interface Presenter extends IPresenterInterface {
    }
}

/**
 * M层注入方式声明
 */
@InstallIn(ActivityComponent.class)
@Module
abstract class LoginProvides {

    @Binds
    abstract LoginInterface.Model provideModel(LoginModel provides);

}
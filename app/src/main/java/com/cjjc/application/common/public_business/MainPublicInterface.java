package com.cjjc.application.common.public_business;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * 业务接口声明->MainPublic
 */
public interface MainPublicInterface {
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
abstract class MainPublicProvides {

    @Binds
    abstract MainPublicInterface.Model provideModel(MainPublicModel provides);

}
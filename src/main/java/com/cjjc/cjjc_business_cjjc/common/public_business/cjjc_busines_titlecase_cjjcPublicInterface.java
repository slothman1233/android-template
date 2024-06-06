package com.cjjc.cjjc_business_cjjc.common.public_business;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * 业务接口声明->cjjc_busines_titlecase_cjjcPublic
 */
public interface cjjc_busines_titlecase_cjjcPublicInterface {
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
abstract class cjjc_busines_titlecase_cjjcPublicProvides {

    @Binds
    abstract cjjc_busines_titlecase_cjjcPublicInterface.Model provideModel(cjjc_busines_titlecase_cjjcPublicModel provides);

}
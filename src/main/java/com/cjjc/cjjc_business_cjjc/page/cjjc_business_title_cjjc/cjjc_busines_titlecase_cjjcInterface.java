package com.cjjc.cjjc_business_cjjc.page.cjjc_business_title_cjjc;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;


public interface cjjc_busines_titlecase_cjjcInterface {

    interface View extends IViewInterface {
    }

    interface Model extends IModelInterface {
    }

    interface Presenter extends IPresenterInterface {
    }

}

@InstallIn(FragmentComponent.class)
@Module
abstract class cjjc_busines_titlecase_cjjcProvides {
    @Binds
    abstract cjjc_busines_titlecase_cjjcInterface.Model providesModel(cjjc_busines_titlecase_cjjcModel hycjjc_busines_titlecase_cjjcModel);
}
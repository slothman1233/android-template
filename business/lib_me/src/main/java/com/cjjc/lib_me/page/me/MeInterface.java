package com.cjjc.lib_me.page.me;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;


public interface MeInterface {

    interface View extends IViewInterface {
    }

    interface Model extends IModelInterface {
    }

    interface Presenter extends IPresenterInterface {
    }

}

@InstallIn(FragmentComponent.class)
@Module
abstract class MeProvides {
    @Binds
    abstract MeInterface.Model providesModel(MeModel hyHomeModel);
}
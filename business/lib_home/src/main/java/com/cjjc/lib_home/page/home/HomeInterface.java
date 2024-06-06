package com.cjjc.lib_home.page.home;

import com.cjjc.lib_base_view.call.mvp.IModelInterface;
import com.cjjc.lib_base_view.call.mvp.IPresenterInterface;
import com.cjjc.lib_base_view.call.mvp.IViewInterface;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;


public interface HomeInterface {

    interface View extends IViewInterface {
    }

    interface Model extends IModelInterface {
    }

    interface Presenter extends IPresenterInterface {
    }

}

@InstallIn(FragmentComponent.class)
@Module
abstract class HomeProvides {
    @Binds
    abstract HomeInterface.Model providesModel(HomeModel hyHomeModel);
}
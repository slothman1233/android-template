package com.cjjc.lib_home.page.home;

import com.cjjc.lib_base_view.view.fragment.BaseFragmentPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Splash
 */
public class HomePresenter extends BaseFragmentPresenter<HomeInterface.Model, HomeInterface.View> implements HomeInterface.Presenter {

    @Inject
    public HomePresenter(HomeInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}

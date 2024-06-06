package com.cjjc.lib_home.common.public_business;

import com.cjjc.lib_base_view.view.fragment.BaseFragmentPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->HomePublic
 */
public class HomePublicPresenter extends BaseFragmentPresenter<HomePublicInterface.Model, HomePublicInterface.View> implements HomePublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public HomePublicPresenter(HomePublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
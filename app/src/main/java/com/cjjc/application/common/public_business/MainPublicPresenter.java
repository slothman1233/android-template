package com.cjjc.application.common.public_business;

import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->MainPublic
 */
public class MainPublicPresenter extends BaseActivityPresenter<MainPublicInterface.Model, MainPublicInterface.View> implements MainPublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public MainPublicPresenter(MainPublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
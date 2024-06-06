package com.cjjc.lib_public.common.public_business;

import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Public
 */
public class PublicPresenter extends BaseActivityPresenter<PublicInterface.Model, PublicInterface.View> implements PublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public PublicPresenter(PublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
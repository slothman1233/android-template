package com.cjjc.lib_me.common.public_business;

import com.cjjc.lib_base_view.view.fragment.BaseFragmentPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->MePublic
 */
public class MePublicPresenter extends BaseFragmentPresenter<MePublicInterface.Model, MePublicInterface.View> implements MePublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public MePublicPresenter(MePublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
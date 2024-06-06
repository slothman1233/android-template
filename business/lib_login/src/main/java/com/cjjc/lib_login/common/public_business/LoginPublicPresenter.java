package com.cjjc.lib_login.common.public_business;

import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->LoginPublic
 */
public class LoginPublicPresenter extends BaseActivityPresenter<LoginPublicInterface.Model, LoginPublicInterface.View> implements LoginPublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public LoginPublicPresenter(LoginPublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
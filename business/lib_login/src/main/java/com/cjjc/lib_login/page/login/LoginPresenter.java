package com.cjjc.lib_login.page.login;


import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Login
 */
public class LoginPresenter extends BaseActivityPresenter<LoginInterface.Model, LoginInterface.View> implements LoginInterface.Presenter {

    //初始化时注入M层
    @Inject
    public LoginPresenter(LoginInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
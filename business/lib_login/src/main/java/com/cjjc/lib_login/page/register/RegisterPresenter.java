package com.cjjc.lib_login.page.register;

import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Register
 */
public class RegisterPresenter extends BaseActivityPresenter<RegisterInterface.Model, RegisterInterface.View> implements RegisterInterface.Presenter {

    //初始化时注入M层
    @Inject
    public RegisterPresenter(RegisterInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
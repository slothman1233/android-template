package com.cjjc.lib_login.page.forget_pwd;


import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->ForgetPwd
 */
public class ForgetPwdPresenter extends BaseActivityPresenter<ForgetPwdInterface.Model, ForgetPwdInterface.View> implements ForgetPwdInterface.Presenter {

    //初始化时注入M层
    @Inject
    public ForgetPwdPresenter(ForgetPwdInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
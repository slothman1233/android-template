package com.cjjc.lib_login.page.forget_pwd;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_login.R;
import com.cjjc.lib_login.common.router.ARouterPathLogin;
import com.cjjc.lib_public.common.base.activity.MyActivityBusinessMvp;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathLogin.APP_LOGIN.PATH_FORGET_PWD_ACTIVITY)
public class ForgetPwdActivity extends MyActivityBusinessMvp<ForgetPwdPresenter> implements ForgetPwdInterface.View {

    @Override
    protected int getLayout() {
        return R.layout.activity_forgetpwd;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initListener() {
    }

}
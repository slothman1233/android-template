package com.cjjc.lib_login.page.login;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_login.R;
import com.cjjc.lib_login.common.router.ARouterPathLogin;
import com.cjjc.lib_public.common.base.activity.MyActivityBusinessMvp;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathLogin.APP_LOGIN.PATH_LOGIN_ACTIVITY)
public class LoginActivity extends MyActivityBusinessMvp<LoginPresenter> implements LoginInterface.View {

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initListener() {
    }

}
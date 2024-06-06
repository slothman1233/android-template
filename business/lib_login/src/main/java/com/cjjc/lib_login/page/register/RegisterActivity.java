package com.cjjc.lib_login.page.register;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_login.R;
import com.cjjc.lib_login.common.router.ARouterPathLogin;
import com.cjjc.lib_public.common.base.activity.MyActivityBusinessMvp;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathLogin.APP_LOGIN.PATH_REGISTER_ACTIVITY)
public class RegisterActivity extends MyActivityBusinessMvp<RegisterPresenter> implements RegisterInterface.View {

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void initListener() {
    }

}
package com.cjjc.lib_login.common.serve.get.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_login.common.router.ARouterPathLogin;
import com.cjjc.lib_login.common.serve.get.call.ServeLoginGetData;

/**
 * 数据服务实现
 */
@Route(path = ARouterPathLogin.APP_LOGIN_SERVE.PATH_GET_DATA, name = "ServeLogin")
public class ServeLoginGetDataImpl implements ServeLoginGetData {

    public ServeLoginGetDataImpl() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void init(Context context) {

    }

}

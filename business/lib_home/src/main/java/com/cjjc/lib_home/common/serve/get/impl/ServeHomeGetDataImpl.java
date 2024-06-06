package com.cjjc.lib_home.common.serve.get.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_home.common.constant.ConstantCodeHome;
import com.cjjc.lib_home.common.router.ARouterPathHome;
import com.cjjc.lib_home.common.serve.get.call.ServeHomeGetData;

/**
 * 数据服务实现
 */
@Route(path = ARouterPathHome.APP_SERVE_HOME.PATH_GET_DATA, name = "ServeHome")
public class ServeHomeGetDataImpl implements ServeHomeGetData {

    public ServeHomeGetDataImpl() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void init(Context context) {

    }

    /**
     * 提供当前业务模块登录鉴权码
     *
     * @return
     */
    @Override
    public int getAuthCodeToLogin() {
        return ConstantCodeHome.CODE_ALL_CHECK_LOGIN;
    }


}

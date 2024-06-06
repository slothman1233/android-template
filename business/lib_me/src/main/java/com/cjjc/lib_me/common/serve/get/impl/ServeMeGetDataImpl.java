package com.cjjc.lib_me.common.serve.get.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_me.common.constant.ConstantCodeMe;
import com.cjjc.lib_me.common.router.ARouterPathMe;
import com.cjjc.lib_me.common.serve.get.call.ServeMeGetData;
import com.cjjc.lib_me.page.me.MeFragment;

/**
 * 数据服务实现
 */
@Route(path = ARouterPathMe.APP_SERVE_ME.PATH_GET_DATA, name = "MeServe")
public class ServeMeGetDataImpl implements ServeMeGetData {


    @Override
    public void init(Context context) {

    }

    /**
     * 提供当前业务模块登录鉴权码
     * @return
     */
    @Override
    public int getAuthCodeToLogin() {
        return ConstantCodeMe.CODE_ALL_CHECK_LOGIN;
    }


}

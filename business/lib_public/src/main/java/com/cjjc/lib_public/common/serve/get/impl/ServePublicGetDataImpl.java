package com.cjjc.lib_public.common.serve.get.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_public.common.router.ARouterPathPublic;
import com.cjjc.lib_public.common.serve.get.call.ServePublicGetData;

/**
 * 数据服务实现
 */
@Route(path = ARouterPathPublic.APP_PUBLIC_SERVE.PATH_GET_DATA, name = "ServePublic")
public class ServePublicGetDataImpl implements ServePublicGetData {


    @Override
    public void init(Context context) {

    }

}

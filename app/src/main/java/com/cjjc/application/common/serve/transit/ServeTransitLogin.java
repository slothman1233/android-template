package com.cjjc.application.common.serve.transit;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.application.common.router.ARouterPathMain;
import com.cjjc.application.common.serve.BusinessServeInject;
import com.cjjc.lib_login.common.serve.set.ServeLoginSetData;

/**
 * 服务中转--Login业务模块
 */
@Route(path = ARouterPathMain.APP_MAIN_SERVE.PATH_SERVE_TRANSIT_LOGIN)
public class ServeTransitLogin implements ServeLoginSetData {

    //总业务服务注入对象
    private BusinessServeInject businessServeInject = BusinessServeInject.getInstance();

    @Override
    public void init(Context context) {
    }


}

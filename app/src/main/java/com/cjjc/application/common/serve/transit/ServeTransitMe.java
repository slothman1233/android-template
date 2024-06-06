package com.cjjc.application.common.serve.transit;

import android.content.Context;


import javax.inject.Inject;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.application.common.router.ARouterPathMain;
import com.cjjc.application.common.serve.BusinessServeInject;
import com.cjjc.lib_me.common.serve.set.ServeMeSetData;

/**
 * 服务中转--Me业务模块
 */
@Route(path = ARouterPathMain.APP_MAIN_SERVE.PATH_SERVE_TRANSIT_ME)
public class ServeTransitMe implements ServeMeSetData {

    //总业务服务注入对象
    private BusinessServeInject businessServeInject = BusinessServeInject.getInstance();

    @Inject
    public ServeTransitMe() {
    }

    @Override
    public void init(Context context) {
    }


}

package com.cjjc.application.common.serve.transit;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.application.common.router.ARouterPathMain;
import com.cjjc.application.common.serve.BusinessServeInject;
import com.cjjc.lib_login.common.router.ARouterPathLogin;
import com.cjjc.lib_public.common.serve.set.ServePublicSetData;

/**
 * 服务中转--Public业务模块
 */
@Route(path = ARouterPathMain.APP_MAIN_SERVE.PATH_SERVE_TRANSIT_PUBLIC)
public class ServeTransitPublic implements ServePublicSetData {
    private Context context;

    //总业务服务注入对象
    private BusinessServeInject businessServeInject = BusinessServeInject.getInstance();


    @Override
    public void init(Context context) {
        this.context=context;
    }


    @Override
    public void toLoginPage(int type) {
        ARouter.getInstance().build(ARouterPathLogin.APP_LOGIN.PATH_LOGIN_ACTIVITY)
                .withInt("type",type)
                .greenChannel()
                .navigation();
    }
}

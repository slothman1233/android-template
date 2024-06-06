package com.cjjc.application.common.serve;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_home.common.serve.get.call.ServeHomeGetData;
import com.cjjc.lib_login.common.serve.get.call.ServeLoginGetData;
import com.cjjc.lib_me.common.serve.get.call.ServeMeGetData;
import com.cjjc.lib_public.common.serve.get.call.ServePublicGetData;

/**
 * 业务服务注入
 */
public class BusinessServeInject {
    private static BusinessServeInject instance;
    //Home数据服务
    @Autowired
    ServeHomeGetData serveHomeGetData;
    //Me数据服务
    @Autowired
    ServeMeGetData serveMeGetData;
    //Login数据服务
    @Autowired
    ServeLoginGetData serveLoginGetData;
    //Public数据服务
    @Autowired
    ServePublicGetData servePublicGetData;

    private BusinessServeInject() {
        ARouter.getInstance().inject(this);
    }

    public static BusinessServeInject getInstance() {
        if (instance == null) {
            synchronized (BusinessServeInject.class) {
                if (instance == null) {
                    instance = new BusinessServeInject();
                }
            }
        }
        return instance;
    }

    /**
     * 提供Home数据服务
     *
     * @return Home数据服务对象
     */
    public ServeHomeGetData getServeHomeGetData() {
        return serveHomeGetData;
    }

    /**
     * 提供Me数据服务
     *
     * @return Me数据服务对象
     */
    public ServeMeGetData getServeMeGetData() {
        return serveMeGetData;
    }

    /**
     * 提供Login数据服务
     *
     * @return Login数据服务对象
     */
    public ServeLoginGetData getServeLoginGetData() {
        return serveLoginGetData;
    }

    /**
     * 提供Public数据服务
     *
     * @return Public数据服务对象
     */
    public ServePublicGetData getServePublicGetData() {
        return servePublicGetData;
    }
}

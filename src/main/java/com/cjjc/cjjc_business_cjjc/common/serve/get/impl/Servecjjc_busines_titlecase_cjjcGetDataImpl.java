package com.cjjc.cjjc_business_cjjc.common.serve.get.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.cjjc_business_cjjc.common.constant.ConstantCodecjjc_busines_titlecase_cjjc;
import com.cjjc.cjjc_business_cjjc.common.router.ARouterPathcjjc_busines_titlecase_cjjc;
import com.cjjc.cjjc_business_cjjc.common.serve.get.call.Servecjjc_busines_titlecase_cjjcGetData;

/**
 * 数据服务实现
 */
@Route(path = ARouterPathcjjc_busines_titlecase_cjjc.APP_SERVE_cjjc_busines_uppercase_cjjc.PATH_GET_DATA, name = "Servecjjc_busines_titlecase_cjjc")
public class Servecjjc_busines_titlecase_cjjcGetDataImpl implements Servecjjc_busines_titlecase_cjjcGetData {

    public Servecjjc_busines_titlecase_cjjcGetDataImpl() {
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
        return ConstantCodecjjc_busines_titlecase_cjjc.CODE_ALL_CHECK_LOGIN;
    }


}

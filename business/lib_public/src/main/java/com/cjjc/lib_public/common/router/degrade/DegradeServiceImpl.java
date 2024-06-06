package com.cjjc.lib_public.common.router.degrade;

import android.content.Context;
import android.content.Intent;

import androidx.core.app.ActivityCompat;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.cjjc.lib_public.page.ErrorActivity;

/**
 * 降级策略：
 * 当页面路由找不到时 默认跳转的页面
 */
@Route(path = DegradeServiceImpl.PATH)
public class DegradeServiceImpl implements DegradeService {
    public static final String PATH = "/service/DegradeServiceImpl";
    @Override
    public void onLost(Context context, Postcard postcard) {
//        if (context != null && postcard.getGroup().equals("activity")) {
        if (context != null) {
            ActivityCompat.startActivity(context, new Intent(context, ErrorActivity.class), null);
        }
    }

    @Override
    public void init(Context context) {

    }
}
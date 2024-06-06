package com.cjjc.application.page.splash;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.application.R;
import com.cjjc.application.common.router.ARouterPathMain;
import com.cjjc.lib_public.common.base.activity.MyActivityBusinessMvp;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathMain.APP_MAIN.HY_SPLASH_ACTIVITY)
public class SplashActivity extends MyActivityBusinessMvp<SplashPresenter> implements SplashInterface.View {

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void init() {
//        mPresenter.getPublicConfig();
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void getPublicConfig() {
        ARouter.getInstance()
                .build(ARouterPathMain.APP_MAIN.HY_MAIN_ACTIVITY)
                .navigation();
    }

}


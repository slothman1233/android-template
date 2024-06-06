package com.cjjc.lib_public.common.router.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_public.common.router.auth.AuthLoginMag;
import com.cjjc.lib_public.common.config.ConfigPublic;
import com.cjjc.lib_public.common.serve.set.ServePublicSetData;

/**
 * 全局--拦截器
 */
@Interceptor(priority = 1, name = "allInterceptor")
public class AllInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extra = postcard.getExtra();
        //判断当前页面是否需要鉴权
        if(AuthLoginMag.getInstance().checkCode(extra)){
            if(!loginCheck()){
                return;
            }
        }
        //放行
        callback.onContinue(postcard);
    }


    @Override
    public void init(Context context) {

    }

    /**
     * 登录业务鉴权
     */
    private boolean loginCheck() {
        if (!ConfigPublic.getInstance().getConfigInfo().getLogin()) {
            ARouter.getInstance().navigation(ServePublicSetData.class).toLoginPage(0);
            return false;
        }
        return true;
    }
}

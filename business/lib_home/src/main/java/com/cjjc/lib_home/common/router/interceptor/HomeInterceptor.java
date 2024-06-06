package com.cjjc.lib_home.common.router.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Home组件-单独业务鉴权拦截器
 */
@Interceptor(priority = 2, name = "homeInterceptor")
public class HomeInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        //业务判断
//        if(MMkvHelper.getInstance().getUserInfo()==null){
//            callback.onInterrupt(null);
//            ARouter.getInstance().build(ARouterPath.APP_LOGIN.LOGIN_ACTIVITY).greenChannel().navigation();
//        }
//        else{
//            callback.onContinue(postcard);
//        }
            callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}

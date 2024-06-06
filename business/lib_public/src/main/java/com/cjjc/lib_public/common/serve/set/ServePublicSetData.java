package com.cjjc.lib_public.common.serve.set;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 暴露接口--向外部索要数据
 */
public interface ServePublicSetData extends IProvider {
    void toLoginPage(int type);//跳转登录
}
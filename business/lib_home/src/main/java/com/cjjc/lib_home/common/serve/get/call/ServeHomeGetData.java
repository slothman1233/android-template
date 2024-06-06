package com.cjjc.lib_home.common.serve.get.call;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 接口暴露--对外提供数据服务能力
 */
public interface ServeHomeGetData extends IProvider {
    int getAuthCodeToLogin(); //对外提供内部登录鉴权码
}
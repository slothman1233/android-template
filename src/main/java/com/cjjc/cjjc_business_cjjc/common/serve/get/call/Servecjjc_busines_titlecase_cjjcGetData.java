package com.cjjc.cjjc_business_cjjc.common.serve.get.call;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 接口暴露--对外提供数据服务能力
 */
public interface Servecjjc_busines_titlecase_cjjcGetData extends IProvider {
    int getAuthCodeToLogin(); //对外提供内部登录鉴权码
}
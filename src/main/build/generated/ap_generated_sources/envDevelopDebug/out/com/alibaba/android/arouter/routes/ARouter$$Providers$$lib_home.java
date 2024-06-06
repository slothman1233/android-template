package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.cjjc.cjjc_business_cjjc.common.serve.get.impl.ServeHomeGetDataImpl;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER.
 */
public class ARouter$$Providers$$cjjc_business_cjjc implements IProviderGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> providers) {
    providers.put("com.cjjc.cjjc_business_cjjc.common.serve.get.call.ServeHomeGetData", RouteMeta.build(RouteType.PROVIDER, ServeHomeGetDataImpl.class, "/home/server/getData", "home", null, -1, -2147483648));
  }
}
package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.cjjc.cjjc_business_cjjc.common.serve.get.impl.ServeHomeGetDataImpl;
import com.cjjc.cjjc_business_cjjc.page.home.HomeFragment;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER.
 */
public class ARouter$$Group$$home implements IRouteGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> atlas) {
    atlas.put("/home/HyHomeFragment", RouteMeta.build(RouteType.FRAGMENT, HomeFragment.class, "/home/hyhomefragment", "home", null, -1, -2147483648));
    atlas.put("/home/server/getData", RouteMeta.build(RouteType.PROVIDER, ServeHomeGetDataImpl.class, "/home/server/getdata", "home", null, -1, -2147483648));
  }
}
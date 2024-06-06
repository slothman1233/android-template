package com.cjjc.lib_home.common.router;

/**
 * Home路由管理
 */
public class ARouterPathHome {
    //首页模块
    public static class APP_HOME {
        private static final String APP_HOME = "/home/";
        public static final String PATH_HOME_FRAGMENT = APP_HOME + "HyHomeFragment";
    }

    //首页模块-接口服务
    public static class APP_SERVE_HOME {
        private static final String APP_SERVE_HOME = "/home/server/";
        public static final String PATH_GET_DATA = APP_SERVE_HOME + "getData";
    }
}

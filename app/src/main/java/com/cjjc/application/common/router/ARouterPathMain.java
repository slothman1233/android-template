package com.cjjc.application.common.router;

/**
 * Home路由管理
 */
public class ARouterPathMain {
    //主工程
    public static class APP_MAIN {
        private static final String PATH_MAIN = "/main/";
        public static final String HY_MAIN_ACTIVITY = PATH_MAIN + "HyMainActivity";
        public static final String HY_SPLASH_ACTIVITY = PATH_MAIN + "HyMainActivity";
    }

    //首页模块-接口服务
    public static class APP_MAIN_SERVE {
        private static final String APP_SERVE_MAIN = "/main/server/";
        public static final String PATH_SERVE_TRANSIT_HOME = APP_SERVE_MAIN + "ServeTransitHome";
        public static final String PATH_SERVE_TRANSIT_ME = APP_SERVE_MAIN + "ServeTransitMe";
        public static final String PATH_SERVE_TRANSIT_PUBLIC = APP_SERVE_MAIN + "ServeTransitPublic";
        public static final String PATH_SERVE_TRANSIT_LOGIN = APP_SERVE_MAIN + "ServeTransitLogin";
    }
}

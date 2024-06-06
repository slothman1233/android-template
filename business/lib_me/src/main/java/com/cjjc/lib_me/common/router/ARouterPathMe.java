package com.cjjc.lib_me.common.router;


/**
 * Me路由管理
 */
public class ARouterPathMe {
    //个人中心模块
    public static class APP_ME {
        private static final String APP_ME = "/me/";
        public static final String PATH_ME_FRAGMENT = APP_ME + "MeFragment";
        public static final String PATH_LANGUAGE_ACTIVITY = APP_ME + "LanguageActivity";
    }

    //个人中心模块-接口服务
    public static class APP_SERVE_ME {
        private static final String APP_SERVE_ME = "/me/server/";
        public static final String PATH_GET_DATA = APP_SERVE_ME + "getData";
    }
}

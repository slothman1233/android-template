package com.cjjc.lib_public.common.router;

/**
 * 公共业务路由管理
 */
public class ARouterPathPublic {
    public static class APP_PUBLIC {
        public static final String APP_UPDATE = "/public/";
        public static final String UPDATE_ACTIVITY = APP_UPDATE + "UpdateActivity";
        public static final String ERROR_ACTIVITY = APP_UPDATE + "ErrorActivity";
    }

    public static class APP_PUBLIC_SERVE {
        private static final String PATH_SERVE_LOGIN = "/public/server/";
        public static final String PATH_GET_DATA = PATH_SERVE_LOGIN + "getData";
    }

}

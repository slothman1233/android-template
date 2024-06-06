package com.cjjc.lib_login.common.router;

/**
 * 登录模块路由管理
 */
public class ARouterPathLogin {
    //登录模块
    public static class APP_LOGIN {
        private static final String APP_LOGIN = "/login/";
        public static final String PATH_LOGIN_ACTIVITY = APP_LOGIN + "LoginActivity";
        public static final String PATH_REGISTER_ACTIVITY = APP_LOGIN + "RegisterActivity";
        public static final String PATH_FORGET_PWD_ACTIVITY = APP_LOGIN + "ForgetPwdActivity";
    }
    public static class APP_LOGIN_SERVE {
        private static final String PATH_SERVE_DARA = "/login/server/";
        public static final String PATH_GET_DATA = PATH_SERVE_DARA + "getData";
    }
}

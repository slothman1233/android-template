package com.cjjc.lib_public.common.router.auth;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录鉴权管理
 */
public class AuthLoginMag {
    private static AuthLoginMag instance;
    private List<Integer> authCodeList = new ArrayList<>();//所有登录鉴权码

    public static AuthLoginMag getInstance() {
        if (instance == null) {
            synchronized (AuthLoginMag.class) {
                if (instance == null) {
                    instance = new AuthLoginMag();
                }
            }
        }
        return instance;
    }

    /**
     * 添加鉴权Code码
     * @param code
     */
    public void addAuthCode(int code) {
        if (!authCodeList.contains(code)) {
            authCodeList.add(code);
        }
    }

    /**
     * 检查当前码是否是登录鉴权码
     *
     * @param code
     * @return
     */
    public boolean checkCode(int code) {
        boolean res = false;
        for (int it : authCodeList) {
            if (it == code) {
                res = true;
                break;
            }
        }
        return res;
    }

}

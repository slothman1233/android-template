package com.cjjc.lib_public.common.config;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_network.rxhttp.RxHttpMag;
import com.cjjc.lib_network.util.RxHttpConfig;
import com.cjjc.lib_public.common.bean.PublicConfigBean;
import com.cjjc.lib_public.common.bean.UserInfo;
import com.cjjc.lib_public.common.constant.ConstantCodePublic;
import com.cjjc.lib_public.common.constant.ConstantKeyPublic;
import com.cjjc.lib_public.common.serve.set.ServePublicSetData;
import com.cjjc.lib_tools.util.AppUtils;
import com.cjjc.lib_tools.util.StringUtil;
import com.cjjc.lib_tools.util.database.MMkvHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 公共工程配置信息
 */
public class ConfigPublicInfo {
    private static ConfigPublicInfo instance;
    //当前登录用户信息
    private UserInfo userInfo;
    //公共配置信息
    private PublicConfigBean publicConfig;
    //是否登录
    private boolean isLogin;
    //Token令牌
    private String token;
    //是否处于强制更新状态中
    private boolean isUpdateIng = false;
    //网络请求错误状态码拦截
    private List<Integer> netErrorCode;

    protected static ConfigPublicInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigPublicInfo.class) {
                if (instance == null) {
                    instance = new ConfigPublicInfo();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        initNetErrorCode();
        RxHttpConfig.getInstance().getHeader().put("version", AppUtils.getVersionName(context));
        RxHttpConfig.getInstance().getHeader().put("versionType", "android");
        //初始化token
        String token = MMkvHelper.getInstance().getString(ConstantKeyPublic.USER_TOKEN_KEY, "");
        if (!StringUtil.isBlank(token)) {
            setLogin(true);
            setToken(token);
        }
        //初始化登录状态
        userInfo = MMkvHelper.getInstance().getBean(ConstantKeyPublic.USER_BEAN_KEY, UserInfo.class);
    }

    /**
     * 初始化-网络请求错误状态码拦截
     */
    private void initNetErrorCode() {
        netErrorCode = new ArrayList<>();
        netErrorCode.add(ConstantCodePublic.CODE_NET_TOKEN);//token失效
        netErrorCode.add(ConstantCodePublic.CODE_APP_UPDATE);//App需要更新
        RxHttpConfig.getInstance().setErrorCode(netErrorCode);
    }

    /**
     * 退出登录
     */
    public void outLogin() {
        MMkvHelper.getInstance().saveBean(ConstantKeyPublic.USER_BEAN_KEY, null);
        MMkvHelper.getInstance().saveString(ConstantKeyPublic.USER_TOKEN_KEY, "");
        setUserInfo(null);
        setLogin(false);
        setToken("");
        RxHttpConfig.getInstance().getHeader().remove("Token");
        ARouter.getInstance().navigation(ServePublicSetData.class).toLoginPage(1);
    }

    /**
     * 设置请求头
     *
     * @param h
     */
    public void setHeader(Map<String, String> h) {
        Set<Map.Entry<String, String>> entries = h.entrySet();
        for (Map.Entry<String, String> item : entries) {
            RxHttpConfig.getInstance().getHeader().put(item.getKey(), item.getValue());
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * 设置用户信息
     *
     * @param userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        if (userInfo != null) {
            MMkvHelper.getInstance().saveBean(ConstantKeyPublic.USER_BEAN_KEY, userInfo);
        }
        this.userInfo = userInfo;
    }

    public boolean getLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        //更新Token
        RxHttpConfig.getInstance().getHeader().put("Token", token);
        this.token = token;
    }

    public boolean getUpdateIng() {
        return isUpdateIng;
    }

    public void setUpdateIng(boolean updateIng) {
        isUpdateIng = updateIng;
    }

    public PublicConfigBean getPublicConfig() {
        return publicConfig;
    }

    public void setPublicConfig(PublicConfigBean publicConfig) {
        this.publicConfig = publicConfig;
    }

    public List<Integer> getNetErrorCode() {
        return netErrorCode;
    }

    public void setNetErrorCode(List<Integer> netErrorCode) {
        this.netErrorCode = netErrorCode;
    }
}

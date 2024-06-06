package com.cjjc.application.common.base;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;

import com.cjjc.application.common.config.ConfigMain;
import com.cjjc.lib_base_view.call.hilt.IApplication;
import com.cjjc.lib_base_view.call.hilt.IDB;
import com.cjjc.lib_public.utils.refresh.SmartRefreshUtil;
import com.cjjc.framework.FrameWork;
import com.cjjc.lib_db.sql.BaseDao;
import com.cjjc.lib_db.sql.BaseDaoFactory;
import com.cjjc.lib_db.sql.IBaseDao;
import com.cjjc.lib_db.sql.UserDao;
import com.cjjc.lib_db.sql.bean.TbUser;
import com.cjjc.lib_db.sql.update.UpdateManager;
import com.cjjc.lib_network.annotation.BindRxHttp;
import com.cjjc.lib_network.base_net.call.IHttp;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application implements IApplication, IDB {

    //注入网络访问接口  一句话切换底层实现框架
    @BindRxHttp
    @Inject
    IHttp http;

    private static MyApplication instance;
    public static MyApplication getInstance() {
        if (instance == null) {
            synchronized (MyApplication.class) {
                if (instance == null) {
                    instance = new MyApplication();
                }
            }
        }
        return instance;
    }

    static {
        //初始化智能刷新组件
        //使用static代码段可以防止内存泄漏
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        //全局设置默认的 Header
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return SmartRefreshUtil.getClassicsHeader();
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return SmartRefreshUtil.getClassicsFooter();
            }
        });
    }

    @Inject
    public MyApplication() {
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FrameWork.getFrameWork().initFrameWork(this);
        ConfigMain.getInstance().init(this);
    }

    /**
     * 网络访问能力
     *
     * @return
     */
    @Override
    public IHttp getIHttp() {
        return http;
    }

    /**
     * 数据库管理
     *
     * @return
     */
    @Override
    public UpdateManager updateManager() {
        return UpdateManager.getInstance();
    }

    /**
     * 提供用户个体操作能力(针对某个用户数据的增、删、改、查)
     *
     * @return 某个用户数据库操作能力
     */
    @Override
    public IBaseDao<TbUser> getUserDao() {
        return BaseDaoFactory.getInstance().getUserDao(UserDao.class, TbUser.class);
    }

    /**
     * 提供个人数据库操作能力
     *
     * @param t   个人数据库的某张表Class对象
     * @param <T> 表的操作对象
     * @return
     */
    @Override
    public <T> BaseDao<T> getAppDao(Class<T> t) {
        return BaseDaoFactory.getInstance().getAppDao(t);
    }


}

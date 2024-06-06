package com.cjjc.application.common.hilt;

import com.cjjc.application.common.base.MyApplication;
import com.cjjc.lib_base_view.call.hilt.IApplication;
import com.cjjc.lib_base_view.call.hilt.IDB;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/**
 * 注入Application接口用于 子工程访问主工程Application内容
 */
@InstallIn(SingletonComponent.class)
@Module
public abstract class IApplicationModule {

    /**
     * 绑定网络请求框架
     *
     * @param http 实现类
     * @return
     */
    @Singleton
    @Binds
    abstract IApplication bindApp(MyApplication http);

    /**
     * 绑定数据库访问框架
     *
     * @param idb 实现类
     * @return
     */
    @Singleton
    @Binds
    abstract IDB dbManager(MyApplication idb);

}

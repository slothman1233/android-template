package com.cjjc.framework;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.framework.manager.CrashMag;
import com.cjjc.framework.manager.DbMag;
import com.cjjc.framework.manager.NetMag;
import com.cjjc.framework.manager.NotificationMag;
import com.cjjc.lib_public.common.constant.ConstantSDKPublic;
import com.cjjc.lib_tools.util.database.MMkvHelper;
import com.cjjc.lib_tools.util.log.LogUtil;
import com.cjjc.lib_tools.util.toast.ToastUtil;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * FrameWork入口
 */
public class FrameWork {

    private static FrameWork mFrameWork = new FrameWork();
    private Disposable obsTime;
    private final String TAG="=_=";

    private FrameWork() {
    }

    public static FrameWork getFrameWork() {
        return mFrameWork;
    }

    /**
     * 初始化
     */
    public void initFrameWork(Application context) {
        //调试模式开启
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        //ARouter路由
        ARouter.init(context);
        //XLog日志打印
        LogUtil.init(BuildConfig.LOG_SWITCH,TAG);
        //创建网络状态监听线程池
        NetMag.getInstance(context).init();
        //MMKV初始化
        MMkvHelper.init(context);
        //数据库初始化配置
        DbMag.init();
        //延时-子线程初始化
        delayTimeInit(context);
    }

    /**
     * Application的优化
     * 1.必要的组件在程序主页去初始化
     * 2.如果组件一定要在App中初始化，那么尽可能的延时
     * 3.非必要的组件，子线程中初始化
     */
    private void delayTimeInit(Application context) {
        obsTime = Observable.timer(1500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (obsTime.isDisposed()) {
                            obsTime.dispose();
                        }
                    }
                });
        myThread(context);
    }

    /**
     * 子线程 初始化 组件
     */
    private void myThread(Application context) {
        Disposable objThread = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Exception {
                //子线程初始化
                //异常捕捉开关
                if (BuildConfig.CRASH_SWITCH) {
                    //Bugly异常上报
                    CrashReport.initCrashReport(context, ConstantSDKPublic.SDK_BUGLY_KEY, false);
                    //全局异常捕捉,做日志输出防止应用崩溃
                    CrashMag.init();
                }
                //初始化消息通知
                NotificationMag.getInstance().init(context);
                //初始化Toasts
                ToastUtil.getInstance().init(context);
            }
        }).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

            }
        });
    }

}

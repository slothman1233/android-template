package com.cjjc.framework.manager;

import com.cjjc.framework.BuildConfig;
import com.cjjc.lib_catch.crash.NeverCrash;

/**
 * 全局异常处理
 */
public class CrashMag {

    public static void init(){
        NeverCrash.getInstance()
                .setDebugMode(BuildConfig.DEBUG)
                .setMainCrashHandler((t, e) -> {
                    //todo 跨线程操作时注意线程调度回主线程操作
//                    Log.d("=_=", "主线程异常");//此处log只是展示，当debug为true时，主类内部log会打印异常信息
                    //todo 此处做你的日志记录即可
                })
                .setUncaughtCrashHandler((t, e) -> {
                    //todo 跨线程操作时注意线程调度回主线程操作
//                    Log.d("=_=", "子线程异常");//此处log只是展示，当debug为true时，主类内部log会打印异常信息
                    //todo 此处做你的日志记录即可
                })
                .register();
    }
}

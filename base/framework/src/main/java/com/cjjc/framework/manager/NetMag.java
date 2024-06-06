package com.cjjc.framework.manager;

import android.app.Application;

import com.cjjc.framework.BuildConfig;
import com.cjjc.lib_network.network.ConnectivityStatus;
import com.cjjc.lib_network.network.ReactiveNetwork;
import com.cjjc.lib_network.rxhttp.RxHttpMag;
import com.cjjc.lib_network.util.GetNetIp;
import com.cjjc.lib_network.util.RxHttpConfig;
import com.cjjc.lib_public.common.constant.ConstantKeyPublic;
import com.cjjc.lib_tools.util.StringUtil;
import com.cjjc.lib_tools.util.database.MMkvHelper;
import com.cjjc.lib_tools.util.log.LogUtil;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 网络状态管理
 */
public class NetMag {

    private static NetMag mInstance;

    private Subscription networkConnectivitySubscription;  //监听网络连接类型的 （数据流量 、wifi 、断线）
    private Subscription internetConnectivitySubscription;  //监听是否链接互联网的 （ 是 ， 否）
    private Subscription wifiSwitchSubscription;  //监听wifi 开关状态的（ wifi 正在打开 、 wifi 打开 、wifi 正在关闭、 wifi 关闭）
    private ReactiveNetwork reactiveNetwork;
    private Application context;

    public static NetMag getInstance(Application context) {
        if (mInstance == null) {
            synchronized (NetMag.class) {
                if (mInstance == null) {
                    mInstance = new NetMag(context);
                }
            }
        }
        return mInstance;
    }

    private NetMag(Application context) {
        this.context = context;
    }

    /**
     * 监听网络状态
     */
    public void init() {
        //初始化网络请求框架
        RxHttpConfig.getInstance()
                .setBaseUrl(BuildConfig.NET_BASE_URL)
                .setIsDebug(BuildConfig.DEBUG)
                .setRequestErrorTag(BuildConfig.REQUEST_ERROR_TAG)
                .init();
        //初始化网络状态监听
        reactiveNetwork = new ReactiveNetwork();
        //监听网络连接类型的 （数据流量 、wifi 、断线）
        networkConnectivitySubscription =
                reactiveNetwork.observeNetworkConnectivity(context)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<ConnectivityStatus>() {
                            @Override
                            public void call(final ConnectivityStatus status) {
                                savePublicNetIp(status);
                            }
                        });

        //监听是否链接互联网的 （ 是 ， 否）
        internetConnectivitySubscription =
                reactiveNetwork.observeInternetConnectivity()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean aBoolean) {
//                                Intent intent=new Intent();
//                                intent.putExtra("netWorkStart",aBoolean);
//                                EventBus.getDefault().post(intent);
                                LogUtil.xLoge("是否有可用的网络==>" + aBoolean);
                            }
                        });

        //监听wifi 开关状态的（ wifi 正在打开 、 wifi 打开 、wifi 正在关闭、 wifi 关闭）
        wifiSwitchSubscription =
                reactiveNetwork.observeWifiSwitch(context)
                        .subscribe(new Action1<ConnectivityStatus>() {
                            @Override
                            public void call(ConnectivityStatus connectivityStatus) {
                                LogUtil.xLoge("wifi 是否打开==>" + connectivityStatus.description);
                            }
                        });
    }

    /**
     * 保存公网IP
     *
     * @param status
     */
    private void savePublicNetIp(ConnectivityStatus status) {
        switch (status.name()) {
            case "WIFI_CONNECTED":
                ConstantKeyPublic.NET_WORK_TYPE = "WIFI";
                getIP();
                break;
            case "MOBILE_CONNECTED":
                ConstantKeyPublic.NET_WORK_TYPE = "4G";
                getIP();
                break;
        }
    }

    /**
     * 获取公网IP
     */
    private void getIP() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = GetNetIp.getNetExtraNetIpAddress();
                if (StringUtil.isBlank(ip)) {
                    ConstantKeyPublic.PUBLIC_NET_IP_VALUE = ip;
                    MMkvHelper.getInstance().saveString(ConstantKeyPublic.PUBLIC_NET_IP_KEY, ip);
                }
            }
        }).start();
    }

    /**
     * 取消订阅
     */
    public void onDestroy() {
        networkConnectivitySubscription.unsubscribe();
        internetConnectivitySubscription.unsubscribe();
        wifiSwitchSubscription.unsubscribe();
    }

}

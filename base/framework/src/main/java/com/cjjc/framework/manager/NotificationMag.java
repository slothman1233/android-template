package com.cjjc.framework.manager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;

import com.cjjc.lib_public.common.constant.ConstantKeyPublic;
import com.cjjc.lib_tools.util.NoticeMessageUtils;


/**
 * 状态栏管理
 */
public class NotificationMag {
    private NotificationManager mManager;  //通知栏管理
    private static NotificationMag mInstance;

    public static NotificationMag getInstance() {
        if (mInstance == null) {
            synchronized (NotificationMag.class) {
                if (mInstance == null) {
                    mInstance = new NotificationMag();
                }
            }
        }
        return mInstance;
    }

    private NotificationMag(){}

    public void init(Context context){
        mManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        initNotification();
        NoticeMessageUtils.init(context, mManager);
    }


    /**
     * 创建渠道
     */
    private void initNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            /**
             * IMPORTANCE_UNSPECIFIED（值为-1）意味着用户没有表达重要性的价值。此值用于保留偏好设置，不应与实际通知关联。
             * IMPORTANCE_NONE（值为0）不重要的通知：不会在阴影中显示。
             * IMPORTANCE_MIN（值为1）最低通知重要性：只显示在阴影下，低于折叠。这不应该与Service.startForeground一起使用，因为前台服务应该是用户关心的事情，所以它没有语义意义来将其通知标记为最低重要性。如果您从Android版本O开始执行此操作，系统将显示有关您的应用在后台运行的更高优先级通知。
             * IMPORTANCE_LOW（值为2）低通知重要性：无处不在，但不侵入视觉。
             * IMPORTANCE_DEFAULT （值为3）：默认通知重要性：随处显示，产生噪音，但不会在视觉上侵入。
             * IMPORTANCE_HIGH（值为4）更高的通知重要性：随处显示，造成噪音和窥视。可以使用全屏的Intent。
             */
            //只在Android O之上需要渠道
            NotificationChannel notificationChannel = new NotificationChannel(ConstantKeyPublic.CHANNEL_ID_KEY,
                    ConstantKeyPublic.CHANNEL_NAME_KEY, NotificationManager.IMPORTANCE_HIGH);
            // 配置通知渠道的属性
            notificationChannel.setDescription("通知提醒");
            // 设置通知出现时的闪灯（如果 android 设备支持的话）
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            // 设置通知出现时的震动（如果 android 设备支持的话）
            notificationChannel.enableVibration(false);
            //如上设置使手机：静止1秒，震动2秒，静止1秒，震动3秒
//            notificationChannel.setVibrationPattern(new long[]{1000, 2000, 1000, 3000});
//            notificationChannel.setVibrationPattern(new long[]{1000, 2000});
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，
            //通知才能正常弹出
            mManager.createNotificationChannel(notificationChannel);
        }
    }
}

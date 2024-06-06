package com.cjjc.lib_public.page;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.lib_public.R;
import com.cjjc.lib_public.common.router.ARouterPathPublic;
import com.cjjc.lib_tools.util.StringUtil;
import com.cjjc.lib_tools.util.log.LogUtil;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.maning.updatelibrary.InstallUtils;

/**
 * 强制更新界面 根据需要自己定制UI
 */
@Route(path = ARouterPathPublic.APP_PUBLIC.UPDATE_ACTIVITY)
public class UpdateActivity extends AppCompatActivity {

    /**
     *         String url="https://cos.pgyer.com/b1c8a5c85aa97640007b601fe7f80cef.apk?sign=2cd19c350247a6532667966801aba86f&t=1643180421&response-content-disposition=attachment%3Bfilename%3D%E6%98%93%E5%A6%99%E4%BA%BA%E7%94%9F_3.0.0.apk";
     *         ARouter.getInstance().build(ARouterPath.APP_UPDATE.UPDATE_ACTIVITY)
     *                 .withString("url", url)
     *                 .withBoolean("isMandatoryUpd",true)
     *                 .navigation();
     */

    @Autowired
    String url;//下载地址
    @Autowired
    boolean isMandatoryUpd;//是否强制更新

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册ARouter路由
        ARouter.getInstance().inject(this);
        LogUtil.xLoge("url-->"+url);
        if(StringUtil.isBlank(url) || !url.endsWith(".apk")){
            finish();
            return;
        }
        checkPer();
    }

    /**
     * 检查权限
     */
    private void checkPer(){
        //1.先判断有没有安装权限---适配8.0
        //如果不想用封装好的，可以自己去实现8.0适配
        InstallUtils.checkInstallPermission(this, new InstallUtils.InstallPermissionCallBack() {
            @Override
            public void onGranted() {
                //去下载Apk
                downloadApk();
            }

            @Override
            public void onDenied() {
                new XPopup.Builder(getBaseContext()).asConfirm(getString(R.string.tips)
                        , getString(R.string.tips_content), getString(R.string.cancel), getString(R.string.confirm), new OnConfirmListener() {
                            @Override
                            public void onConfirm() {
                                openSetting();
                            }
                        }, new OnCancelListener() {
                            @Override
                            public void onCancel() {

                            }
                        },false).show();
            }
        });
    }

    private void openSetting(){
        //打开设置页面
        InstallUtils.openInstallPermissionSetting(this, new InstallUtils.InstallPermissionCallBack() {
            @Override
            public void onGranted() {
                //去下载Apk
                downloadApk();
            }

            @Override
            public void onDenied() {
                //还是不允许咋搞？
                Toast.makeText(getBaseContext(), "不允许安装咋搞？强制更新就退出应用程序吧！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 下载Apk
     */
    private void downloadApk() {
        //2.下载APK
        InstallUtils.with(this)
                //必须-下载地址
                .setApkUrl(url)
                //非必须-下载保存的文件的完整路径+/name.apk，使用自定义路径需要获取读写权限
//                .setApkPath(Constants.APK_SAVE_PATH)
                //非必须-下载回调
                .setCallBack(new InstallUtils.DownloadCallBack() {
                    @Override
                    public void onStart() {
                        //下载开始
                        LogUtil.xLoge("开始下载-->onStart");
                    }

                    @Override
                    public void onComplete(String path) {
                        LogUtil.xLoge("下载完成-->onComplete");
                        //下载完成
                        installAPK(path);

                    }

                    @Override
                    public void onLoading(long total, long current) {
                        //下载中
                        LogUtil.xLoge("下载中-->onLoading"+total+"\t"+current);
                    }

                    @Override
                    public void onFail(Exception e) {
                        //下载失败
                        LogUtil.xLoge("下载失败-->onFail"+e.getMessage());
                    }

                    @Override
                    public void cancle() {
                        //下载取消
                        LogUtil.xLoge("下载取消-->cancle");
                    }
                })
                //开始下载
                .startDownload();
    }

    private void installAPK(String path) {
        InstallUtils.installAPK(this, path, new InstallUtils.InstallCallBack() {
            @Override
            public void onSuccess() {
                //onSuccess：表示系统的安装界面被打开
                //防止用户取消安装，在这里可以关闭当前应用，以免出现安装被取消
                Toast.makeText(getBaseContext(), "正在安装程序", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(Exception e) {
                //安装出现异常，这里可以提示用用去用浏览器下载安装
            }
        });
    }


}
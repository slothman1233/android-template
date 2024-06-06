package com.cjjc.lib_public.common.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.cjjc.lib_base_view.view.activity.BaseActivityMvp;
import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;
import com.cjjc.lib_public.common.listener.MyBusinessViewInterface;
import com.cjjc.lib_public.widget.dialog.DialogLoading;
import com.cjjc.lib_public.widget.dialog.DialogLoadingResult;
import com.cjjc.lib_public.widget.tsnackbar.SnackBarType;
import com.cjjc.lib_public.widget.tsnackbar.SnackBarUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * Activity基础业务
 */
public abstract class MyActivityBusinessMvp<P extends BaseActivityPresenter> extends BaseActivityMvp<P> implements MyBusinessViewInterface {

    private DialogLoading loading;//加载框

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 显示提示框
     */
    @Override
    public void showLoading() {
        if (loading == null) {
            loading = new DialogLoading(context);
        }
        loading.show();
    }

    /**
     * 显示提示框
     *
     * @param msg 提示内容
     */
    @Override
    public void showLoading(String msg) {
        if (loading == null) {
            loading = new DialogLoading(context);
        }
        loading.show(msg);
    }

    /**
     * 显示提示框
     *
     * @param msg 提示内容
     */
    @Override
    public void showLoading(int msg) {
        if (loading == null) {
            loading = new DialogLoading(context);
        }
        loading.show(context.getString(msg));
    }

    /**
     * 关闭提示框
     */
    @Override
    public void dismissLoading() {
        if (loading != null) {
            loading.dismiss();
        }
    }

    /**
     * 显示结果 并关闭弹窗
     *
     * @param type 提示类型
     * @param msg  内容
     */
    @Override
    public void dismissLoadingShowMsg(DialogLoadingResult type, String msg) {
        if (loading != null) {
            loading.dismissShowMsg(type, msg);
        }
    }

    /**
     * 显示结果 并关闭弹窗
     *
     * @param type 提示类型
     * @param msg  内容
     */
    @Override
    public void dismissLoadingShowMsg(DialogLoadingResult type, int msg) {
        if (loading != null) {
            loading.dismissShowMsg(type, context.getString(msg));
        }
    }

    /**
     * 顶部下拉式Toast提示
     *
     * @param msg  String 类型提示信息
     * @param type SUCCESS,
     *             ERROR,
     *             WARN
     */
    @Override
    public void showSnackBar(String msg, SnackBarType type) {
        SnackBarUtil.showSnackBar(this, msg, type);
    }

    /**
     * 顶部下拉式Toast提示
     *
     * @param msg  int(R.string.name) 类型提示信息
     * @param type SUCCESS,
     *             ERROR,
     *             WARN
     */
    @Override
    public void showSnackBar(int msg, SnackBarType type) {
        SnackBarUtil.showSnackBar(this, context.getString(msg), type);
    }

}

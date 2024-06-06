package com.cjjc.lib_public.common.listener;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.cjjc.lib_public.widget.dialog.DialogLoadingResult;
import com.cjjc.lib_public.widget.tsnackbar.SnackBarType;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * Activity、Fragment通用业务
 */
public interface MyBusinessViewInterface {

    /**
     * 显示提示框
     */
    void showLoading();

    /**
     * 显示提示框
     *
     * @param msg 提示内容
     */
    void showLoading(String msg);

    /**
     * 显示提示框
     *
     * @param msg 提示内容
     */
    void showLoading(int msg);

    /**
     * 关闭提示框
     */
    void dismissLoading();

    /**
     * 显示结果 并关闭弹窗
     *
     * @param type 提示类型
     * @param msg  内容
     */
    void dismissLoadingShowMsg(DialogLoadingResult type, String msg);

    /**
     * 显示结果 并关闭弹窗
     *
     * @param type 提示类型
     * @param msg  内容
     */
    void dismissLoadingShowMsg(DialogLoadingResult type, int msg);

    /**
     * 顶部下拉式Toast提示
     *
     * @param msg  String 类型提示信息
     * @param type SUCCESS,
     *             ERROR,
     *             WARN
     */
    void showSnackBar(String msg, SnackBarType type);

    /**
     * 顶部下拉式Toast提示
     *
     * @param msg  int(R.string.name) 类型提示信息
     * @param type SUCCESS,
     *             ERROR,
     *             WARN
     */
    void showSnackBar(int msg, SnackBarType type);


}

package com.cjjc.lib_public.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

import com.cjjc.lib_public.R;


/**
 * 提示布局(加载中,无网络,空值提示,漏掉了出错)还有很大的优化空间
 */
public class TipLayout extends RelativeLayout {

    private View netErrorView;
    private View loadingView;

    private final SparseArray<View> views;
    /**
     * 是否正在刷新
     */
    public boolean isRefreshing = false;
    private LayoutInflater inflater;
    private Animation animation;


    public TipLayout(Context context) {
        super(context);
        this.views = new SparseArray<View>();
        initView(context, null, 0);
    }

    public TipLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.views = new SparseArray<View>();
        initView(context, attrs, 0);
    }

    public TipLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.views = new SparseArray<View>();
        initView(context, attrs, defStyleAttr);
    }

    private void initView(final Context context, AttributeSet attrs, int defStyleAttr) {
        inflater = LayoutInflater.from(context);
        netErrorView = inflater.inflate(R.layout.widget_network_error, null);
        loadingView = inflater.inflate(R.layout.widget_loading, null);
        animation = AnimationUtils.loadAnimation(context, R.anim.alpha_tiplayout);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        netErrorView.setLayoutParams(params);
        loadingView.setLayoutParams(params);


        addView(netErrorView);
        addView(loadingView);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //重新加载点击事件
        netErrorView.findViewById(R.id.baseTvReload).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onReloadClick != null) {
                    showLoading();
                    onReloadClick.onReload();
                }
            }
        });


        //判断当前是否可见,显示loading
        if (getVisibility() == View.VISIBLE)
            showLoading();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                clearAnimation();
                //invalidate();
                setVisibility(GONE);
                isRefreshing = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void resetStatus() {
        this.setVisibility(VISIBLE);
        netErrorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        if (null != diyEmptyView) {
            diyEmptyView.setVisibility(View.GONE);
        }
    }


    /**
     * 现实文本内容
     */
    public void showContent() {
        if (isRefreshing)
            startAnimation(animation);
    }

    /**
     * 显示加载中布局
     */
    public void showLoading() {
        resetStatus();
        setBackgroundResource(R.color.color_xml_bg);
        loadingView.setVisibility(VISIBLE);
        isRefreshing = true;
    }

    /**
     * 显示透明的加载中布局
     */
    public void showLoadingTransparent() {
        resetStatus();
        setBackgroundResource(android.R.color.transparent);
        loadingView.setVisibility(VISIBLE);
        isRefreshing = true;
    }

    /**
     * 显示没有网络
     */
    public void showNetError() {
        setBackgroundResource(R.color.color_xml_bg);
        resetStatus();
        netErrorView.setVisibility(VISIBLE);
        isRefreshing = false;
    }

    /**
     * 显示空数据
     */
    public void showEmpty() {
        if (null == diyEmptyView) {
            setBackgroundResource(R.color.color_white);
            resetStatus();
        } else {
            setBackgroundResource(R.color.color_white);
            //存在自定义空值layout
            this.setVisibility(VISIBLE);
            netErrorView.setVisibility(View.GONE);
            loadingView.setVisibility(View.GONE);
            diyEmptyView.setVisibility(VISIBLE);
        }
        isRefreshing = false;
    }


    /**
     * 重新加载点击事件
     */
    OnReloadClick onReloadClick;

    public void setOnReloadClick(OnReloadClick onReloadClick) {
        this.onReloadClick = onReloadClick;
    }

    public interface OnReloadClick {
        void onReload();
    }

    private View diyEmptyView;//自定义空值layout

    /**
     * 自定义空值layout
     *
     * @param resourceId
     * @return 返回的view可以进行其他操作，例如绑定控件
     */
    public View setEmptyLayout(@LayoutRes int resourceId) {
        diyEmptyView = inflater.inflate(resourceId, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        diyEmptyView.setLayoutParams(params);
        addView(diyEmptyView);
        return diyEmptyView;
    }

    public <T extends View> T getEmptyView(@IdRes int viewId) {
        return retrieveView(viewId);
    }

    public View getEmptyView() {
        if (diyEmptyView != null) {
            return diyEmptyView;
        } else {
            return null;
        }
    }

    protected <T extends View> T retrieveView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = diyEmptyView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}

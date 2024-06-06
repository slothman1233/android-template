package com.cjjc.lib_public.utils.refresh;

import android.content.Context;

import com.cjjc.lib_tools.util.AppGlobalUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;

public class SmartRefreshUtil {
   private static Context context = AppGlobalUtils.getApplication().getApplicationContext();

    /**
     * 上拉加载样式自定义
     *
     * @return
     */
    public static RefreshFooter getClassicsFooter() {
//        ClassicsFooter.REFRESH_FOOTER_PULLING = context.getString(R.string.refresh_footer_pulling);//"上拉加载更多";
//        ClassicsFooter.REFRESH_FOOTER_RELEASE = context.getString(R.string.refresh_footer_release);//"释放立即加载";
//        ClassicsFooter.REFRESH_FOOTER_REFRESHING = context.getString(R.string.refresh_footer_refreshing);//"正在刷新...";
//        ClassicsFooter.REFRESH_FOOTER_LOADING = context.getString(R.string.refresh_footer_loading);//"正在加载...";
//        ClassicsFooter.REFRESH_FOOTER_FINISH = context.getString(R.string.refresh_footer_finish);//"加载完成";
//        ClassicsFooter.REFRESH_FOOTER_FAILED = context.getString(R.string.refresh_footer_failed);//"加载失败";
//        ClassicsFooter.REFRESH_FOOTER_NOTHING = context.getString(R.string.refresh_footer_nothing);//"没有更多数据了";

        ClassicsFooter footer = new ClassicsFooter(context);
//        footer.setAccentColor(context.getColor(R.color.red));//设置强调颜色
//        footer.setPrimaryColor(context.getColor(R.color.blue));//设置主题颜色
        footer.setTextSizeTitle(16);//设置标题文字大小（sp单位）
//        footer.setTextSizeTitle(16, TypedValue.COMPLEX_UNIT_SP);//同上
//        footer.setFinishDuration(500);//设置刷新完成显示的停留时间
        footer.setDrawableSize(16);//同时设置箭头和图片的大小（dp单位）
//        footer.setDrawableArrowSize(20);//设置箭头的大小（dp单位）
//        footer.setDrawableProgressSize(20);//设置图片的大小（dp单位）
//        footer.setDrawableMarginRight(20);//设置图片和箭头和文字的间距（dp单位）
//        footer.setDrawableSizePx(20);//同上-像素单位（1.1.0版本删除）
//        footer.setDrawableArrowSizePx(20);//同上-像素单位（1.1.0版本删除）
//        footer.setDrawableProgressSizePx(20);//同上-像素单位（1.1.0版本删除）
//        footer.setDrawableMarginRightPx(20);//同上-像素单位（1.1.0版本删除）
//        footer.setArrowBitmap(bitmap);//设置箭头位图（1.1.0版本删除）
//        footer.setArrowDrawable(drawable);//设置箭头图片
//        footer.setArrowResource(R.drawable.iv_back);//设置箭头资源
//        footer.setProgressBitmap(bitmap);//设置图片位图（1.1.0版本删除）
//        footer.setProgressDrawable(drawable);//设置图片
//        footer.setProgressResource(R.drawable.ic_progress);//设置图片资源
//        footer.setSpinnerStyle(SpinnerStyle.Translate);//设置移动样式（不支持：MatchLayout）
        return footer;
    }

    /**
     * 下拉刷新样式定义
     *
     * @return
     */
    public static RefreshHeader getClassicsHeader( ) {

//        ClassicsHeader.REFRESH_HEADER_PULLING = context.getString(R.string.refresh_header_pulldown);//"下拉可以刷新";
//        ClassicsHeader.REFRESH_HEADER_REFRESHING = context.getString(R.string.refresh_header_refreshing);//"正在刷新...";
//        ClassicsHeader.REFRESH_HEADER_LOADING = context.getString(R.string.refresh_header_loading);//"正在加载...";
//        ClassicsHeader.REFRESH_HEADER_RELEASE = context.getString(R.string.refresh_header_release);//"释放立即刷新";
//        ClassicsHeader.REFRESH_HEADER_FINISH = context.getString(R.string.refresh_header_finish);//"刷新完成";
//        ClassicsHeader.REFRESH_HEADER_FAILED = context.getString(R.string.refresh_header_failed);//"刷新失败";
//        ClassicsHeader.REFRESH_HEADER_SECONDARY = context.getString(R.string.refresh_header_secondary);//"释放进入二楼";
//        ClassicsHeader.REFRESH_HEADER_UPDATE = context.getString(R.string.refresh_header_update);//"上次更新 M-d HH:mm";
        ClassicsHeader header = new ClassicsHeader(context);
//        header.setAccentColor(context.getColor(R.color.white));//设置强调颜色
//        header.setPrimaryColor(context.getColor(R.color.white));//设置主题颜色
        header.setTextSizeTitle(16);//设置标题文字大小（sp单位）
//        header.setTextSizeTitle(16, TypedValue.COMPLEX_UNIT_SP);//同上（1.1.0版本删除）
//        header.setTextSizeTime(10);//设置时间文字大小（sp单位）
//        header.setTextSizeTime(10, TypedValue.COMPLEX_UNIT_SP);//同上（1.1.0版本删除）
//        header.setTextTimeMarginTop(10);//设置时间文字的上边距（dp单位）
//        header.setTextTimeMarginTopPx(10);//同上-像素单位（1.1.0版本删除）
//        header.setEnableLastTime(true);//是否显示时间
//        header.setFinishDuration(500);//设置刷新完成显示的停留时间（设为0可以关闭停留功能）
        header.setDrawableSize(16);//同时设置箭头和图片的大小（dp单位）
//        header.setDrawableArrowSize(20);//设置箭头的大小（dp单位）
//        header.setDrawableProgressSize(20);//设置图片的大小（dp单位）
//        header.setDrawableMarginRight(20);//设置图片和箭头和文字的间距（dp单位）
//        header.setDrawableSizePx(20);//同上-像素单位
//        header.setDrawableArrowSizePx(20);//同上-像素单位（1.1.0版本删除）
//        header.setDrawableProgressSizePx(20);//同上-像素单位（1.1.0版本删除）
//        header.setDrawableMarginRightPx(20);//同上-像素单位（1.1.0版本删除）
//        header.setArrowBitmap(bitmap);//设置箭头位图（1.1.0版本删除）
//        header.setArrowDrawable(drawable);//设置箭头图片
//        header.setArrowResource(R.drawable.iv_back);//设置箭头资源
//        header.setProgressBitmap(bitmap);//设置图片位图（1.1.0版本删除）
//        header.setProgressDrawable(drawable);//设置图片
//        header.setProgressResource(R.drawable.ic_progress);//设置图片资源
//        header.setTimeFormat(new DynamicTimeFormat("上次更新 %s"));//设置时间格式化（时间会自动更新）
//        header.setLastUpdateText("上次更新 3秒前");//手动更新时间文字设置（将不会自动更新时间）
//        header.setSpinnerStyle(SpinnerStyle.Translate);//设置移动样式（不支持：MatchLayout）
        return header;
    }

}

package com.cjjc.lib_public.widget.tsnackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjjc.lib_base_view.view.activity.BaseActivity;
import com.cjjc.lib_public.R;
import com.cjjc.lib_tools.util.StringUtil;
import com.cjjc.lib_tools.util.screen.ScreenUtil;

public class SnackBarUtil {

    /**
     * 顶部下拉式Toast提示
     *
     * @param view
     * @param text
     * @param type 1 成功 2 失败 3
     */
    public static void showSnackBar(BaseActivity view, String text, SnackBarType type) {
        if (view != null) {
            try {
                TSnackbar snackBar = TSnackbar
                        .make(view.getWindow().getDecorView(), text, TSnackbar.LENGTH_SHORT);
                View snackBarView = snackBar.getView();
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ScreenUtil.dp2px(view, 88));
                snackBarView.setLayoutParams(layoutParams);

                ImageView imageView = snackBarView.findViewById(R.id.iv_state);

                switch (type) {
                    case SUCCESS:
                        imageView.setImageResource(R.drawable.base_iv_tips_success);
                        break;
                    case ERROR:
                        imageView.setImageResource(R.drawable.base_iv_tips_error);
                        break;
                    case WARN:
                        imageView.setImageResource(R.drawable.base_iv_tips_warn);
                        break;
                }

                TextView textView = snackBarView.findViewById(R.id.snackbar_texts);
                textView.setText(text);
                snackBar.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

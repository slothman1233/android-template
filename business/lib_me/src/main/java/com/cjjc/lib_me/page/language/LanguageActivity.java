package com.cjjc.lib_me.page.language;

import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_base_view.constant.ConstantKeyBaseView;
import com.cjjc.lib_base_view.view.activity.BaseActivity;
import com.cjjc.lib_me.R;
import com.cjjc.lib_me.R2;
import com.cjjc.lib_me.common.router.ARouterPathMe;
import com.cjjc.lib_tools.util.database.MMkvHelper;
import com.cjjc.lib_tools.util.language.LanguageConstants;

import java.util.List;
import java.util.Locale;

import butterknife.BindViews;
import butterknife.OnClick;

@Route(path = ARouterPathMe.APP_ME.PATH_LANGUAGE_ACTIVITY)
public class LanguageActivity extends BaseActivity {

    @BindViews({R2.id.iv_chinese, R2.id.iv_english})
    List<ImageView> ivImg;
    private String type;
    private String lanuage;
    private boolean isReStart = true;

    @Override
    protected int getLayout() {
        return R.layout.activity_language;
    }

    @Override
    protected void init() {
        type = getIntent().getStringExtra("type");
        lanuage = MMkvHelper.getInstance().getString(ConstantKeyBaseView.SAVE_LANGUAGE_KEY, Locale.getDefault().getLanguage());
        switch (lanuage) {
            case "zh":
                ivImg.get(0).setImageResource(R.drawable.me_language_select);
                break;
            case "en":
                ivImg.get(1).setImageResource(R.drawable.me_language_select);
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R2.id.ll_english, R2.id.ll_chinese})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.ll_chinese) {
            switchLanguage(LanguageConstants.SIMPLIFIED_CHINESE);
        } else if (id == R.id.ll_english) {
            switchLanguage(LanguageConstants.ENGLISH);
        }
    }

    /**
     * 切换语言
     * @param language
     */
    private void switchLanguage(String language) {
        if (lanuage.equals(language)) {
            isReStart = false;
        } else {
            isReStart = true;
            MMkvHelper.getInstance().saveString(ConstantKeyBaseView.SAVE_LANGUAGE_KEY, language);
        }
        if (isReStart) {
            lanuage = MMkvHelper.getInstance().getString(ConstantKeyBaseView.SAVE_LANGUAGE_KEY, LanguageConstants.SIMPLIFIED_CHINESE);
            reStartAppMain();
        }
    }

    /**
     * 重新启动APP
     */
    private void reStartAppMain() {
//        AppManager.getInstance().finishAllActivity();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("startType", "language");
//        startActivity(intent);
//        finish();
    }

    /**
     * 重新启动APP
     */
    private void reStartAppLogin() {
//        Intent intent = new Intent(this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);
    }
}
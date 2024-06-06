package com.cjjc.application.page.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cjjc.application.R;
import com.cjjc.application.common.constant.ConstantCodeMain;
import com.cjjc.lib_base_view.view.adapter.PagerAdapter;
import com.cjjc.lib_home.page.home.HomeFragment;
import com.cjjc.lib_login.common.router.ARouterPathLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import dagger.hilt.android.AndroidEntryPoint;
import com.cjjc.application.common.router.ARouterPathMain;
import com.cjjc.lib_me.common.constant.ConstantCodeMe;
import com.cjjc.lib_me.page.me.MeFragment;
import com.cjjc.lib_public.common.base.activity.MyActivityBusinessMvp;
import com.cjjc.lib_public.common.config.ConfigPublic;
import com.cjjc.lib_tools.util.event.EventMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 主页面
 */
@AndroidEntryPoint
@Route(path = ARouterPathMain.APP_MAIN.HY_MAIN_ACTIVITY, extras = ConstantCodeMain.CODE_ALL_CHECK_LOGIN)
public class MainActivity extends MyActivityBusinessMvp<MainPresenter> implements MainInterface.View {

    @BindView(R.id.vp)
    ViewPager2 vp;
    @BindViews({R.id.ll_home, R.id.ll_find, R.id.ll_me})
    List<LinearLayout> menuListLayout;
    @BindViews({R.id.iv_home, R.id.iv_find, R.id.iv_me})
    List<ImageView> menuListImg;
    @BindViews({R.id.tv_home, R.id.tv_find, R.id.tv_me})
    List<TextView> menuListText;

    private ArrayList<Fragment> fragmentList;
    private HomeFragment homeFragment;
    private HomeFragment findFragment;
    private MeFragment meFragment;
    private int index = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        fragmentList = new ArrayList<>();
        homeFragment = new HomeFragment();
        findFragment = new HomeFragment();
        meFragment = new MeFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(findFragment);
        fragmentList.add(meFragment);
        vp.setOffscreenPageLimit(3);
        vp.setUserInputEnabled(false);//禁用滑动
        vp.setAdapter(new PagerAdapter(this, fragmentList));
        switchPage(index);
        if (ConfigPublic.getInstance().getConfigInfo().getLogin()) {
            EventBus.getDefault().post(new EventMessage(ConstantCodeMe.CODE_REFRESH_ME_INFO));
        }
    }
    @OnClick({R.id.ll_home, R.id.ll_find, R.id.ll_me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                switchPage(0);
                break;
            case R.id.ll_find:
                switchPage(1);
                break;
            case R.id.ll_me:
                switchPage(2);
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    /**
     * 切换页面
     *
     * @param index
     */
    private void switchPage(int index) {
        this.index = index;
        if (index == 1 || index == 2) {
            if (!ConfigPublic.getInstance().getConfigInfo().getLogin()) {
                ARouter.getInstance().build(ARouterPathLogin.APP_LOGIN.PATH_LOGIN_ACTIVITY).greenChannel().navigation();
                return;
            }
        }
        vp.setCurrentItem(index);
        for (ImageView img : menuListImg) {
            img.setSelected(false);
        }
        for (TextView text : menuListText) {
            text.setTextColor(context.getColor(R.color.color_text_979797));
        }
        menuListImg.get(index).setSelected(true);
        menuListText.get(index).setTextColor(context.getColor(R.color.color_text_3a3a3a));
    }

    /**
     * http框架状态码处理
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Map<String, Integer> event) {
        switch (event.get("netStateCode")) {
            case 401://Token失效
                ConfigPublic.getInstance().getConfigInfo().outLogin();
                break;
            case 666://版本低于服务器需要更新
                if (!ConfigPublic.getInstance().getConfigInfo().getUpdateIng()) {
                    ConfigPublic.getInstance().getConfigInfo().setUpdateIng(true);
//                    homeFragment.getSysVersion();
                }
                break;
        }
    }

    @Override
    public boolean isDoubleClickExit() {
        return true;
    }
}
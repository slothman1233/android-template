package com.cjjc.lib_home.page.home;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_home.R;
import com.cjjc.lib_home.R2;
import com.cjjc.lib_home.common.router.ARouterPathHome;
import com.cjjc.lib_public.common.base.fragment.MyFragmentBusinessMvp;

import butterknife.BindView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathHome.APP_HOME.PATH_HOME_FRAGMENT)
public class HomeFragment extends MyFragmentBusinessMvp<HomePresenter> implements HomeInterface.View{

    @BindView(R2.id.tv_action)
    Button tvAction;

    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
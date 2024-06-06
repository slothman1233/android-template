package com.cjjc.cjjc_business_cjjc.page.cjjc_business_title_cjjc;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.cjjc_business_cjjc.R;
import com.cjjc.cjjc_business_cjjc.R2;
import com.cjjc.cjjc_business_cjjc.common.router.ARouterPathcjjc_busines_titlecase_cjjc;
import com.cjjc.lib_public.common.base.fragment.MyFragmentBusinessMvp;

import butterknife.BindView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathcjjc_busines_titlecase_cjjc.APP_cjjc_busines_uppercase_cjjc.PATH_cjjc_busines_uppercase_cjjc_FRAGMENT)
public class cjjc_busines_titlecase_cjjcFragment extends MyFragmentBusinessMvp<cjjc_busines_titlecase_cjjcPresenter> implements cjjc_busines_titlecase_cjjcInterface.View{

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
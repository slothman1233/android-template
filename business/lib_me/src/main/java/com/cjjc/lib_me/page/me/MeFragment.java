package com.cjjc.lib_me.page.me;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_me.R;
import com.cjjc.lib_me.R2;
import com.cjjc.lib_me.common.router.ARouterPathMe;
import com.cjjc.lib_public.common.base.fragment.MyFragmentBusinessMvp;

import butterknife.BindView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@Route(path = ARouterPathMe.APP_ME.PATH_ME_FRAGMENT)
public class MeFragment extends MyFragmentBusinessMvp<MePresenter> implements MeInterface.View{

    @BindView(R2.id.tv_action)
    Button tvAction;


    @Override
    protected int getViewId() {
        return R.layout.fragment_me;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void init(Bundle savedInstanceState) {
        tvAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mPresenter.getText();
            }
        });
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
package com.cjjc.lib_me.page.me;

import com.cjjc.lib_base_view.view.fragment.BaseFragmentPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Splash
 */
public class MePresenter extends BaseFragmentPresenter<MeInterface.Model, MeInterface.View> implements MeInterface.Presenter {

    @Inject
    public MePresenter(MeInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }
}

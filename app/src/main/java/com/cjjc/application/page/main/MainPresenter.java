package com.cjjc.application.page.main;


import com.cjjc.lib_base_view.view.activity.BaseActivityPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->Splash
 */
public class MainPresenter extends BaseActivityPresenter<MainInterface.Model, MainInterface.View> implements MainInterface.Presenter{

    @Inject
    public MainPresenter(MainInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }


}

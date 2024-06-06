package com.cjjc.cjjc_business_cjjc.common.public_business;

import com.cjjc.lib_base_view.view.fragment.BaseFragmentPresenter;

import javax.inject.Inject;

/**
 * 业务调度控制器->cjjc_busines_titlecase_cjjcPublic
 */
public class cjjc_busines_titlecase_cjjcPublicPresenter extends BaseFragmentPresenter<cjjc_busines_titlecase_cjjcPublicInterface.Model, cjjc_busines_titlecase_cjjcPublicInterface.View> implements cjjc_busines_titlecase_cjjcPublicInterface.Presenter {

    //初始化时注入M层
    @Inject
    public cjjc_busines_titlecase_cjjcPublicPresenter(cjjc_busines_titlecase_cjjcPublicInterface.Model mModel) {
        super(mModel);
    }

    @Override
    public void onInit() {

    }

}
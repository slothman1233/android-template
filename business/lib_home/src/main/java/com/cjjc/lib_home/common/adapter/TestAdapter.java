package com.cjjc.lib_home.common.adapter;

import com.cjjc.lib_base_view.view.adapter.recycle.BaseRecycleListAdapter;
import com.cjjc.lib_base_view.view.adapter.recycle.BaseViewHolder;
import com.cjjc.lib_home.common.bean.TestBean;

import java.util.List;


public class TestAdapter extends BaseRecycleListAdapter<TestBean> {


    public TestAdapter(List<TestBean> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void bindData(BaseViewHolder holder, TestBean bean, int position) {
    }
}
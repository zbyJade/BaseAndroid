package com.zc.zby.basicframedemo.activity;

import android.os.Bundle;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.base.BaseActivity;

import butterknife.BindView;

public class FrescoActivity extends BaseActivity {

    @BindView(R.id.easyRecyclerView)
    protected EasyRecyclerView easyRecyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fresco;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {

    }
}

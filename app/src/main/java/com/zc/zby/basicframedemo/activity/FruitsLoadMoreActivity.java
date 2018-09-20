package com.zc.zby.basicframedemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.adapter.FruitsAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;

import java.util.Arrays;

import butterknife.BindView;

import static com.zc.zby.basicframedemo.data.DataUtils.fruits;

public class FruitsLoadMoreActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener, RecyclerArrayAdapter.OnNoMoreListener {

    @BindView(R.id.easyRecyclerView)
    protected EasyRecyclerView mEasyRecyclerView;
    private FruitsAdapter fruitsAdapter;
    private Handler handler = new Handler();
    private boolean hasNetWork = true;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fruits;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mEasyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(this, 0.5f));
        mEasyRecyclerView.addItemDecoration(itemDecoration);
        mEasyRecyclerView.setAdapter(fruitsAdapter = new FruitsAdapter(this));
    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("加载更多");
    }

    @Override
    public void setListeners() {
        mEasyRecyclerView.setRefreshListener(this);
        fruitsAdapter.setMore(R.layout.view_more, this);
        fruitsAdapter.setNoMore(R.layout.view_no_more, this);
    }

    @Override
    public void initData() {
        fruitsAdapter.addAll(Arrays.asList(fruits));
    }

    @Override
    public void onRefresh() {
        mEasyRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                page = 0;
                fruitsAdapter.clear();
                fruitsAdapter.addAll(Arrays.asList(fruits));
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                if (!hasNetWork) {
                    fruitsAdapter.pauseMore();
                    return;
                }
                page++;
                if (page > 2) {
                    fruitsAdapter.stopMore();
                } else {
                    fruitsAdapter.addAll(Arrays.asList(fruits));
                }
            }
        }, 2000);
    }

    @Override
    public void onNoMoreShow() {

    }

    @Override
    public void onNoMoreClick() {

    }
}

package com.zc.zby.basicframedemo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.adapter.MainAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RecyclerArrayAdapter.OnItemClickListener {

    @BindView(R.id.EasyRecyclerView)
    protected EasyRecyclerView mEasyRecyclerView;
    private String[] strings = {
            "GreenDao使用", "RecyclerView加载更多-水果", "Fresco加载图片",
            "TabLayout+viewPager+fragment", "Tiny图片压缩", "商品层级联动界面",
            "高仿ios右滑finish"};
    private MainAdapter mainAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initPermission();
        mEasyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(this, 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(false);
        mEasyRecyclerView.addItemDecoration(itemDecoration);
        mEasyRecyclerView.setAdapter(mainAdapter = new MainAdapter(this));
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void setListeners() {
        mainAdapter.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        if (Arrays.asList(strings).size() <= 0) {
            mEasyRecyclerView.showEmpty();
        } else {
            mainAdapter.addAll(Arrays.asList(strings));
        }
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(UserDaoActivity.class);
                break;
            case 1:
                startActivity(FruitsLoadMoreActivity.class);
                break;
            case 2:
                startActivity(FrescoActivity.class);
                break;
            case 3:
                startActivity(ShowFragmentActivity.class);
                break;
            case 4:
                startActivity(TinyActivity.class);
                break;
            case 5:
                startActivity(LevelLinkageActivity.class);
                break;
            case 6:
                startActivity(SwipeFinishActivity.class);
                break;

        }
    }

    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);
                // 进入到这里代表没有权限.
            }
        }
        String[] tmpList = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
    }
}

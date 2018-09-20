package com.zc.zby.basicframedemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.adapter.MyFragmentPagerAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;
import com.zc.zby.basicframedemo.fragment.OneFragment;

import butterknife.BindView;

/**
 * Created by ${USER_NAME} on 2018/9/13.
 */
public class ShowFragmentActivity extends BaseActivity {

    @BindView(R.id.tabLayout)
    protected TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    protected ViewPager mViewPager;
    private String[] mTitles = {"One", "Two", "Three"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_show_fragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        for (String title : mTitles) {
            myFragmentPagerAdapter.addFragment(OneFragment.newInstance(title), title);
        }
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//此方法就是让tablayout和ViewPager联动

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("TabLayout+ViewPager+Fragment");
    }

    @Override
    public void initData() {

    }
}

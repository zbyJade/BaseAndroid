package com.zc.zby.basicframedemo.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by ${USER_NAME} on 2018/9/13.
 */
public class OneFragment extends BaseFragment {

    private String mTitle;
    @BindView(R.id.text)
    protected TextView mText;

    public static OneFragment newInstance(String title) {
        OneFragment oneFragment = new OneFragment();
        oneFragment.mTitle = title;
        return oneFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mText.setText(mTitle);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initData() {

    }
}

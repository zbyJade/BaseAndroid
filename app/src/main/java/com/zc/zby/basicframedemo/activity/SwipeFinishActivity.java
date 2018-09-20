package com.zc.zby.basicframedemo.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.MotionEvent;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.adapter.ImageWallAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;
import com.zc.zby.basicframedemo.swipehelper.SwipeHelper;
import com.zc.zby.basicframedemo.utils.ImageDataUtil;

import butterknife.BindView;

/**
 * Created by ${USER_NAME} on 2018/9/19.
 */
public class SwipeFinishActivity extends BaseActivity {
    @BindView(R.id.easyRecyclerView)
    protected EasyRecyclerView mEasyRecyclerView;
    private ImageWallAdapter imageWallAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.acitivity_swipe_finish;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        DividerDecoration dividerDecoration = new DividerDecoration(R.color.text_color, Util.dip2px(this, 1));
        mEasyRecyclerView.addItemDecoration(dividerDecoration);
        mEasyRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        imageWallAdapter = new ImageWallAdapter(this);
        mEasyRecyclerView.setAdapter(imageWallAdapter);
    }

    @Override
    public void setListeners() {
    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("右滑finish");
    }

    @Override
    public void initData() {
        imageWallAdapter.addAll(ImageDataUtil.images);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean processTouchEvent = SwipeHelper.instance().processTouchEvent(ev);
        if (processTouchEvent) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
}

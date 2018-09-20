package com.zc.zby.basicframedemo.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.zby.basicframedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity implements BaseInterface{

    private LinearLayout parentLinearLayout;
    @BindView(R.id.tv_title)
    protected TextView mTvTitle;
    @BindView(R.id.tv_right)
    protected TextView mTvRight;
    @BindView(R.id.back_layout)
    protected LinearLayout mBackLayout;
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    private boolean mIsShowBacking = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initTitleView(R.layout.activity_base_title);
        //设置布局内容
        setContentView(getLayoutId());
        //ButterKnife
        ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        setBackIcon();
        //初始化监听器
        setListeners();
        //初始化数据
        initData();
    }

    /**
     * @param titleLayoutResID the layout id of title layout
     */
    private void initTitleView(@LayoutRes int titleLayoutResID) {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new LinearLayout(this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(parentLinearLayout);
        LayoutInflater.from(this).inflate(titleLayoutResID, parentLinearLayout, true);
    }

    /**
     * @param layoutResID the layout id of sub Activity
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //  added the sub-activity layout id in parentLinearLayout
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    /**
     * @return TextView in center
     */
    public TextView getToolbarTitle() {
        return mTvTitle;
    }

    /**
     * @return TextView on the right
     */
    public TextView getRightTitle() {
        return mTvRight;
    }

    /**
     * set Title
     *
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        } else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    private void setBackIcon() {
        if (null != getToolbar() && isShowBacking()) {
            mBackLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            mBackLayout.setVisibility(View.GONE);
        }
    }

    /**
     * the toolbar of this Activity
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return mToolbar;
    }

    /**
     * is show back icon,default is none。
     * you can override the function in subclass and return to true show the back icon
     *
     * @return
     */
    protected boolean isShowBacking() {
        return mIsShowBacking;
    }

    /**
     * is show back icon,default is none。
     * you can override the function in subclass and return to true show the back icon
     *
     * @return
     */
    protected void setIsShowBacking(boolean isShowBacking) {
        mIsShowBacking = isShowBacking;
    }


    /**
     * 跳转到指定的Activity
     *
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull Class<?> targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }

    /**
     * 跳转到指定的Activity
     *
     * @param data           Activity之间传递数据，Intent的Extra key为Constant.EXTRA_NAME.DATA
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull String name, @NonNull Bundle data, @NonNull Class<?> targetActivity) {
        final Intent intent = new Intent();
        intent.putExtra(name, data);
        intent.setClass(this, targetActivity);
        startActivity(intent);
    }
}

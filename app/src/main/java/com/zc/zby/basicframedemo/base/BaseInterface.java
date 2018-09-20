package com.zc.zby.basicframedemo.base;

import android.os.Bundle;

/**
 * Created by ${USER_NAME} on 2018/9/13.
 */
public interface BaseInterface {

    int getLayoutId();

    void initViews(Bundle savedInstanceState);

    void setListeners();

    void initToolBar();

    void initData();
}

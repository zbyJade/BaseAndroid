package com.zc.zby.basicframedemo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ${USER_NAME} on 2018/9/13.
 */
public abstract class BaseFragment extends Fragment implements BaseInterface {

    private Context context;
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        initViews(savedInstanceState);
        setListeners();
        initData();
        if (rootView != null)
            return rootView;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void startActivity(Class<?> cls) {
        startActivity(getIntent(cls));
    }

    protected Intent getIntent() {
        return getActivity().getIntent();
    }

    protected Intent getIntent(Class<?> cls) {
        return new Intent(context, cls);
    }

}

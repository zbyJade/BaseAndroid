package com.zc.zby.basicframedemo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${USER_NAME} on 2018/8/29.
 */
public class AdapterViewUtil {

    // 用于adapter 设置viewLayout
    public static View getItemLayouts(Context context, int viewType, int... layoutIds) {
        if (viewType < 0)
            return null;
        if (layoutIds == null)
            return null;
        if (layoutIds.length < 1)
            return null;
        int itemLayoutId;
        if (layoutIds.length == 1) {
            itemLayoutId = layoutIds[0];
        } else {
            itemLayoutId = layoutIds[viewType];
        }
        View view = LayoutInflater.from(context).inflate(itemLayoutId, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;
    }

}

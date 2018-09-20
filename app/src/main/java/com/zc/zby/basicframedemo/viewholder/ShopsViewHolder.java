package com.zc.zby.basicframedemo.viewholder;

import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zc.zby.basicframedemo.R;

/**
 * Created by ${USER_NAME} on 2018/9/17.
 */
public class ShopsViewHolder extends BaseViewHolder<String> {

    private final TextView mTvShopsName;

    public ShopsViewHolder(View itemView) {
        super(itemView);
        mTvShopsName = $(R.id.shops_name);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        mTvShopsName.setText(data);
    }
}

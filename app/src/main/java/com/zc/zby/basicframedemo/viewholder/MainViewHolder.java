package com.zc.zby.basicframedemo.viewholder;

import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zc.zby.basicframedemo.R;

/**
 * Created by ${USER_NAME} on 2018/8/29.
 */
public class MainViewHolder extends BaseViewHolder<String> {

    private final TextView mTvMain;

    public MainViewHolder(View itemView) {
        super(itemView);
        mTvMain = $(R.id.main_text);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        mTvMain.setText(data);
    }
}

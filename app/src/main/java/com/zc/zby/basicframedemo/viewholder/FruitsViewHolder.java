package com.zc.zby.basicframedemo.viewholder;

import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zc.zby.basicframedemo.R;

/**
 * Created by ${USER_NAME} on 2018/8/29.
 */
public class FruitsViewHolder extends BaseViewHolder<String> {

    private TextView mTvFruits;

    public FruitsViewHolder(View itemView) {
        super(itemView);
        mTvFruits = $(R.id.text_fruits);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        mTvFruits.setText(getAdapterPosition() + " " + data);
    }
}

package com.zc.zby.basicframedemo.viewholder;

import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zc.zby.basicframedemo.R;

import java.util.ArrayList;

/**
 * Created by ${USER_NAME} on 2018/9/17.
 */
public class LabelViewHolder extends BaseViewHolder<String> {

    private TextView mTvLabelName;
    private View mViewLabel;
    private ArrayList<Boolean> mCheckList;

    public LabelViewHolder(View itemView) {
        super(itemView);
        mTvLabelName = $(R.id.label_name);
        mViewLabel = $(R.id.label_view);
    }

    public LabelViewHolder setCheckedList(ArrayList<Boolean> checkList) {
        mCheckList = checkList;
        return this;
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        mTvLabelName.setText(data);
        for (int i = 0; i < mCheckList.size(); i++) {
            if (mCheckList.get(i)) {
                if (i == getAdapterPosition()) {
                    mViewLabel.setVisibility(View.VISIBLE);
                } else {
                    mViewLabel.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
}

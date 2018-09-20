package com.zc.zby.basicframedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.utils.AdapterViewUtil;
import com.zc.zby.basicframedemo.viewholder.LabelViewHolder;

import java.util.ArrayList;

/**
 * Created by ${USER_NAME} on 2018/9/17.
 */
public class LabelAdapter extends RecyclerArrayAdapter<String> {
    private ArrayList<Boolean> mCheckList;

    public LabelAdapter(Context context) {
        super(context);
    }

    public LabelAdapter setChecked(ArrayList<Boolean> checkedList) {
        mCheckList = checkedList;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = AdapterViewUtil.getItemLayouts(parent.getContext(), viewType, R.layout.item_label);
        LabelViewHolder labelViewHolder = new LabelViewHolder(view);
        labelViewHolder.setCheckedList(mCheckList);
        return labelViewHolder;
    }
}

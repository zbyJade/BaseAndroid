package com.zc.zby.basicframedemo.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.adapter.LabelAdapter;
import com.zc.zby.basicframedemo.adapter.ShopsAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by ${USER_NAME} on 2018/9/17.
 */
public class LevelLinkageActivity extends BaseActivity {
    @BindView(R.id.easyRecyclerView1)
    protected EasyRecyclerView mEasyRecyclerView1;
    @BindView(R.id.easyRecyclerView2)
    protected EasyRecyclerView mEasyRecyclerView2;
    private String[] labels1 = {"上衣", "下衣", "内裤", "鞋袜", "帽子", "手机", "护肤品", "日用品"};
    private String[] labels2_0 = {"上衣0", "上衣1", "上衣2", "上衣3", "上衣4", "上衣5", "上衣6", "上衣7"};
    private String[] labels2_1 = {"下衣0", "下衣1", "下衣2", "下衣3", "下衣4", "下衣5", "下衣6", "下衣7"};
    private String[] labels2_2 = {"内裤0", "内裤1", "内裤2", "内裤3", "内裤4", "内裤5", "内裤6", "内裤7"};
    private String[] labels2_3 = {"鞋袜0", "鞋袜1", "鞋袜2", "鞋袜3", "鞋袜4", "鞋袜5", "鞋袜6", "鞋袜7"};
    private String[] labels2_4 = {"帽子0", "帽子1", "帽子2", "帽子3", "帽子4", "帽子5", "帽子6", "帽子7"};
    private String[] labels2_5 = {"手机0", "手机1", "手机2", "手机3", "手机4", "手机5", "手机6", "手机7"};
    private String[] labels2_6 = {"护肤品0", "护肤品1", "护肤品2", "护肤品3", "护肤品4", "护肤品5", "护肤品6", "护肤品7"};
    private String[] labels2_7 = {"日用品0", "日用品1", "日用品2", "日用品3", "日用品4", "日用品5", "日用品6", "日用品7"};
    private HashMap<Integer, String[]> hashMap;
    private LabelAdapter labelAdapter;
    private ShopsAdapter shopsAdapter;
    private ArrayList<Boolean> checkList;
    private int mLablePosition;
    private String[] shops;

    @Override
    public int getLayoutId() {
        return R.layout.activity_level_linkage;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        DividerDecoration dividerDecoration = new DividerDecoration(R.color.text_color, Util.dip2px(this, 1));
        mEasyRecyclerView1.addItemDecoration(dividerDecoration);
        mEasyRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        labelAdapter = new LabelAdapter(this);
        mEasyRecyclerView1.setAdapter(labelAdapter);
        mEasyRecyclerView2.setLayoutManager(new GridLayoutManager(this, 3));
        shopsAdapter = new ShopsAdapter(this);
        mEasyRecyclerView2.setAdapter(shopsAdapter);
    }

    @Override
    public void setListeners() {
        labelAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mLablePosition = position;
                for (int i = 0; i < checkList.size(); i++) {
                    if (position == i) {
                        checkList.set(i, true);
                    } else {
                        checkList.set(i, false);
                    }
                }
                labelAdapter.setChecked(checkList);
                shops = hashMap.get(position);
                shopsAdapter.clear();
                shopsAdapter.addAll(shops);
            }
        });
        shopsAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(LevelLinkageActivity.this, "label: " + labels1[mLablePosition] + "  " + "shop: " + shops[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("商品层级联动");
    }

    @Override
    public void initData() {
        // 初始化
        checkList = new ArrayList<>();
        for (int i = 0; i < labels1.length; i++) {
            if (i == 0) {
                checkList.add(true);
            } else {
                checkList.add(false);
            }
        }
        hashMap = new HashMap();
        hashMap.put(0, labels2_0);
        hashMap.put(1, labels2_1);
        hashMap.put(2, labels2_2);
        hashMap.put(3, labels2_3);
        hashMap.put(4, labels2_4);
        hashMap.put(5, labels2_5);
        hashMap.put(6, labels2_6);
        hashMap.put(7, labels2_7);
        labelAdapter.addAll(labels1);
        labelAdapter.setChecked(checkList);
        shopsAdapter.addAll(hashMap.get(0));
    }
}

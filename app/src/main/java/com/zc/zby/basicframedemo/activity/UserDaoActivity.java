package com.zc.zby.basicframedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.greendao.adapter.UserAdapter;
import com.zc.zby.basicframedemo.base.BaseActivity;
import com.zc.zby.basicframedemo.greendao.bean.UserInfo;
import com.zc.zby.basicframedemo.greendao.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zby on 2018/7/19.
 */
public class UserDaoActivity extends BaseActivity {

    @BindView(R.id.bt_add)
    protected Button btnAdd;
    @BindView(R.id.bt_delete)
    protected Button btnDelete;
    @BindView(R.id.bt_query)
    protected Button btnQuery;
    @BindView(R.id.bt_update)
    protected Button btnUpdate;
    @BindView(R.id.bt_query_key)
    protected Button btnQueryKey;
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;
    private List<UserInfo> lists = new ArrayList<>();
    private UserAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_dao;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        adapter = new UserAdapter(this, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initToolBar() {
        getToolbarTitle().setText("Greendao数据库使用");
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initData() {

    }

    @Nullable
    @OnClick({R.id.bt_add, R.id.bt_delete, R.id.bt_update, R.id.bt_query, R.id.bt_query_key})
    protected void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                addData();
                break;
            case R.id.bt_delete:
                deleteData();
                break;
            case R.id.bt_update:
                updateData();
                break;
            case R.id.bt_query:
                queryListData();
                break;
            case R.id.bt_query_key:
                queryUserDataByName("李四");
                break;
        }
    }

    /**
     * 更新数据
     */
    private void updateData() {
        if (!lists.isEmpty()) {
            UserInfo userInfo = lists.get(0);
            userInfo.setName("李四");
            UserDao.getInstance().updateUserData(userInfo);
            queryListData();
        }
    }

    /**
     * 删除数据
     */
    private void deleteData() {
        if (!lists.isEmpty()) {
            UserDao.getInstance().deleteUserData(lists.get(0));
            queryListData();
        }

    }

    /**
     * 添加数据
     */
    private void addData() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setAge(18);
        userInfo.setSex(1);
        UserDao.getInstance().insertUserData(userInfo);
        queryListData();
    }

    /**
     * 查询数据
     */
    private void queryListData() {
        lists = UserDao.getInstance().queryAllData();
        adapter.setData(lists);
        Toast.makeText(this, "查询到" + lists.size() + "条数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 根据主键查询
     *
     * @param name
     * @return
     */
    public void queryUserDataByName(String name) {
        List<UserInfo> userInfos = UserDao.getInstance().queryUserByName(name);
        lists.clear();
        lists = userInfos;
        adapter.setData(lists);
    }
}

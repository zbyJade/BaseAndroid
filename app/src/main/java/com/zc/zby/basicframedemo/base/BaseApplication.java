package com.zc.zby.basicframedemo.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.facebook.fresco.helper.Phoenix;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cookie.store.MemoryCookieStore;
import com.zc.zby.basicframedemo.greendao.GreenDaoManager;
import com.zc.zby.basicframedemo.swipehelper.ActivityLifeHelper;
import com.zxy.tiny.Tiny;

/**
 * Created by zby on 2018/7/19.
 */
public class BaseApplication extends MultiDexApplication {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        // 初始化greendao
        GreenDaoManager.getInstance();
        // 初始化frescohelper
        Phoenix.init(this);
        // 图片压缩初始化
        Tiny.getInstance().init(this);
        // 初始化OkHttpUtils
        initOkHttpUtils();
    }
    public static Context getContext(){
        return context;
    }

    private void initOkHttpUtils() {
        //所有的 header 都 不支持 中文
        //所有的 params 都 支持 中文
        //必须调用初始化
        OkHttpUtils.init(this);
        //cookie持久化存储，如果cookie不过期，则一直有效
        OkHttpUtils.getInstance().setCookieStore(new MemoryCookieStore());
        //注册可右滑删除的界面
        registerActivityLifecycleCallbacks(ActivityLifeHelper.instance());
    }
}

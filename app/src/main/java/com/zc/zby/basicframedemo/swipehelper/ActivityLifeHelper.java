package com.zc.zby.basicframedemo.swipehelper;

import android.app.Activity;
import android.os.Bundle;

import java.util.Stack;

/**
 * Created by ${USER_NAME} on 2018/9/19.
 */
public class ActivityLifeHelper extends BaseActivityLifecycle {

    private static ActivityLifeHelper sLifecycleHelper;
    private Stack<Activity> mActivityStack;

    private ActivityLifeHelper() {
        mActivityStack = new Stack<>();
    }

    public static ActivityLifeHelper instance() {
        if (sLifecycleHelper == null) {
            synchronized (ActivityLifeHelper.class) {
                if (sLifecycleHelper == null) {
                    sLifecycleHelper = new ActivityLifeHelper();
                }
            }
        }
        return sLifecycleHelper;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        addActivity(activity);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.add(activity);
        }
    }

    /**
     * 将Activity从堆栈移除
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
        }
    }

    /**
     * 获取当前Activity
     */
    public Activity getCurrentActivity() {
        Activity activity = mActivityStack.lastElement();
        return activity;
    }

    /**
     * 获取上一个Activity
     */
    public Activity getPreviewActivity() {
        int size = mActivityStack.size();
        if (size < 2) return null;
        return mActivityStack.elementAt(size - 2);
    }
}

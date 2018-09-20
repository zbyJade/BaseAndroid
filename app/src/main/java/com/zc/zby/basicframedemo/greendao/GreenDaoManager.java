package com.zc.zby.basicframedemo.greendao;


import com.zc.zby.basicframedemo.base.BaseApplication;
import com.zc.zby.basicframedemo.greendao.gen.DaoMaster;
import com.zc.zby.basicframedemo.greendao.gen.DaoSession;
import com.zc.zby.basicframedemo.greendao.helper.MySQLiteOpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zby on 2018/7/19.
 */

public class GreenDaoManager {
    private static final String DB_NAME="greendao";

    private static GreenDaoManager mInstance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static GreenDaoManager getInstance(){
        if(mInstance==null){
            synchronized (GreenDaoManager.class){
                if(mInstance==null){
                    mInstance =new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    private GreenDaoManager(){
        if(mInstance==null){
            MySQLiteOpenHelper helper =new MySQLiteOpenHelper(BaseApplication.getContext(),DB_NAME,null);
            Database db = helper.getWritableDb();
            daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

    public DaoMaster getDaoMaster(){
        return daoMaster;
    }

}

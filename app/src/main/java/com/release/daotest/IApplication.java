package com.release.daotest;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.release.daotest.greendao.DaoMaster;
import com.release.daotest.greendao.DaoSession;
import com.release.daotest.room.AppDatabase;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */

public class IApplication extends Application {
    public static Context context;
    private static IApplication mContext;
    public static IApplication getInstance() {
        return mContext;
    }
    public AppDatabase db;
    public DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mContext = this;
        initRoom();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greendao-student", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
    }

    private void initRoom() {
        db = Room.databaseBuilder(this,
                AppDatabase.class,
                "room-user")
                .allowMainThreadQueries()//允许在主线程中查询
                .fallbackToDestructiveMigration()//将会删除数据库并重建…
//                .addMigrations(MIGRATION_1_2)//数据库升级,migrate
                .build();
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //新增字段
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN last_update INTEGER");
            // 创建临时表
//            database.execSQL(
//                    "CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");
            // 拷贝数据
//            database.execSQL(
//                    "INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users");
            // 删除老的表
//            database.execSQL("DROP TABLE users");
            // 改名
//            database.execSQL("ALTER TABLE users_new RENAME TO users");
        }
    };
}

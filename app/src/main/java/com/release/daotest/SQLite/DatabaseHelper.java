package com.release.daotest.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by corleone on 2018/3/8.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private final static String TAG = "DatabaseHelper";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null){
            synchronized (DatabaseHelper.class){
                if (instance == null){
                    instance = new DatabaseHelper(context);
                }
            }
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, "sqlite_persons.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table persons(id integer primary key,name text,phone integer,age integer)";
        db.execSQL(sql1);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "drop table if exists persons";
        db.execSQL(sql1);
        onCreate(db);
        Log.i(TAG, "onUpgrade: ------------版本升级");
    }
}

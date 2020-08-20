package com.release.daotest.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */
@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

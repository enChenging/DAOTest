package com.release.daotest.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */
@Dao
public interface UserDao {

    @Insert
    void insertAll(List<User> users);

    @Insert
    void insert(User... users);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user")
    void deleteAllUser();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateUsers(User... user);

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user LIMIT 100 OFFSET :index")
    List<User> selectUsers(int index);

    @Query("SELECT * FROM user WHERE userId IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);




}

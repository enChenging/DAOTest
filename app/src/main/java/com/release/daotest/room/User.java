package com.release.daotest.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */
@Entity
public class User {
    //自增
    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String username;
    private int age;
    @ColumnInfo(name = "phone_number")
    private int phone;

//    private String last_update;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


//    public String getLast_update() {
//        return last_update;
//    }
//
//    public void setLast_update(String last_update) {
//        this.last_update = last_update;
//    }
}

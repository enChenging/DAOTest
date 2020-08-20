package com.release.daotest.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */
@Entity
public class Student {
    //不能用int
    @Id(autoincrement = true)
    private Long id;
    //姓名
    @NotNull
    private String name;

    private int phone;

    private int age;

    private String last_update;

    @Generated(hash = 1072879916)
    public Student(Long id, @NotNull String name, int phone, int age,
            String last_update) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.last_update = last_update;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }

    public String getLast_update() {
        return this.last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

package com.release.daotest.SQLite;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */

public class Person {

    private int id;
    private String name;
    private int phone;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }
}

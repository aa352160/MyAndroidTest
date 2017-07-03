package com.example.pcdalao.mytest.realm;

import io.realm.RealmObject;

/**
 * Created by pan jh on 2017/6/5.
 */

public class Dog extends RealmObject{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

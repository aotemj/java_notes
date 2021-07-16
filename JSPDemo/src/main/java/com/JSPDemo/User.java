package com.JSPDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
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

    public String getBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        return sdf.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date birthday;
}

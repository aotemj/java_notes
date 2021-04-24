package com.test02;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo6 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 通过反射实现如下操作：
        //        Student s = new Student();
        //    s.name = "林青霞";
        //    s.age =30;
        //    s.address  = "西安"
        //        System.out.println(s);

        Class<?> c = Class.forName("com.test01.Student");

        Object s = c.newInstance();
        Field name = c.getDeclaredField("name");
        // 暴力反射，取消当前反射访问限制
        name.setAccessible(true);
        name.set(s, "林青霞");

        Field age = c.getDeclaredField("age");
        age.setAccessible(true);
        age.set(s, 30);

        Field address = c.getField("address");
        address.set(s, "西安");

        System.out.println(s);
    }
}

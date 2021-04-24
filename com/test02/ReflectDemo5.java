package com.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

// 通过反射获取成员变量
public class ReflectDemo5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        // 获取Class 对象
        Class<?> c = Class.forName("com.test01.Student");
        // 获取当前类的所有公共成员变量
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获取当前类的所有成员方法
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }


        System.out.println("-----------");

        // 为当前实例对象的成员变量赋值：
        Object obj = c.newInstance();
        Field address = c.getField("address");
        address.set(obj, "西安");
        System.out.println(obj);
    }
}

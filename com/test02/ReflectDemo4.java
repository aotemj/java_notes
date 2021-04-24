package com.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
// 通过反射获取私有构造方法
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c1 = Class.forName("com.test01.Student");
        Constructor<?> con = c1.getDeclaredConstructor(String.class);
        // 暴力反射
        con.setAccessible(true); // 取消访问检查（构造方法为 private 时无法使用该构造方法 实例化对象）
        Object o = con.newInstance("林青霞");
        System.out.println(o);
    }
}

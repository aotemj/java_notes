package com.test02;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {
    public static void main(String arg[]) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> c = Class.forName("com.test01.Student");
        // 通过反射获取当前类的所有构造方法
        Constructor<?>[] cons = c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }

        System.out.println("----------");

        // 获取当前无参构造方法
        Constructor<?> c2 = c.getConstructor();
        System.out.println(c2);

        //         获取当前有参构造方法
        Constructor<?> c3 = c.getConstructor(String.class, int.class, String.class);
        System.out.println(c3);
        //         获取当前私有构造方法
        Constructor<?>[] c4 = c.getDeclaredConstructors();
        for (Constructor con : c4) {
            System.out.println(con);
        }
        System.out.println("---------");

        // 获取当前单个私有构造方法

        Constructor<?> c5 = c.getDeclaredConstructor(String.class);
        System.out.println(c5);
    }
}

package com.test03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// 反射练习
public class ReflectTest1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 有一个 ArrayList<Integer> 集合，现在要在当前集合中添加一个 字符串，如何实现

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);

        Class<? extends ArrayList> aClass = arrayList.getClass();

        Method add = aClass.getMethod("add", Object.class);

        add.invoke(arrayList, "hello");
        add.invoke(arrayList, "string");
        System.out.println(arrayList);
    }
}

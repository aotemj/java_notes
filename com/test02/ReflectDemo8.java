package com.test02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
// 获取成员方法并调用
public class ReflectDemo8 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = Class.forName("com.test01.Student");

        Object obj = c.newInstance();

        Method method1 = c.getMethod("method1");
        // 调用 obj 的 method1 方法
        method1.invoke(obj);

        Method method2 = c.getMethod("method2", String.class);

        method2.invoke(obj, "invoke method2");

        Method method3 = c.getMethod("method3", String.class, int.class);

        System.out.println(method3.invoke(obj, "hello", 30));
    }
}

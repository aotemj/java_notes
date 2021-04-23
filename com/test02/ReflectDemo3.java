package com.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c1 = Class.forName("com.test01.Student");
        // Student s = new Student("林青霞"，30，"西安");
        // System.out.println(s);
        Constructor<?> c2 = c1.getConstructor(String.class, int.class, String.class);
        Object o = c2.newInstance("林青霞", 30, "西安");
        System.out.println(o); //Student{name=林青霞'',age=30,address=西安''}
    }
}

package com;

//  类加载器
public class ClassLoaderDemo {
    public static void main(String args[]) {
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        System.out.println(c1); //sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader c2 = c1.getParent();
        System.out.println(c2); //sun.misc.Launcher$ExtClassLoader@4554617c
        ClassLoader c3 = c2.getParent();
        System.out.println(c3);//null
    }
}

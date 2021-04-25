package com.test02;

import java.lang.reflect.Method;

public class ReflectDemo7 {
    // 通过反射获取类的成员方法
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("com.test01.Student");
        // Method[] getMethods 返回一个包含方法对象的数组， 方法对象反映由该Class  对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类 和超级接口继承的类
        // Method[] getDeclaredMethods () 返回一个包含方法对象的数组，方法对象反映由 Class 对象表示的类或接口的所有声明方法，包括 public, protected, default(package)访问 和私有方法，但不包括继承方法
        Method[] methods = c.getMethods();

        for (Method method : methods) {
            System.out.println(method);
            // public java.lang.String com.test01.Student.toString()
            // public void com.test01.Student.method1()
            // public void com.test01.Student.method2(java.lang.String)
            // public java.lang.String com.test01.Student.method3(java.lang.String,int)
            // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            // public final void java.lang.Object.wait() throws java.lang.InterruptedException
            // public boolean java.lang.Object.equals(java.lang.Object)
            // public native int java.lang.Object.hashCode()
            // public final native java.lang.Class java.lang.Object.getClass()
            // public final native void java.lang.Object.notify()
            // public final native void java.lang.Object.notifyAll()
        }

    }
}

package com.test04;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

// 通过配置文件动态加载类、调用类的方法
public class ReflectDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Properties props = new Properties();
        FileReader fr = new FileReader("com/test04/config.txt");
        props.load(fr);
        fr.close();

        String className = props.getProperty("className");
        String method = props.getProperty("method");
        Class<?> aClass = Class.forName(className);

        Method method1 = aClass.getMethod(method);

        Object obj = aClass.newInstance();
        method1.invoke(obj);
    }
}

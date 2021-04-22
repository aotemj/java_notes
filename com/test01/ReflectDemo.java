package com.test01;

/**
 * 三种获取class 对象的方法
 * 1.使用class类的属性来获取该类对应的Class 对象
 * 2. 调用该对象的getClass ,返回该对象所属类对应的Class 对象
 * 注意：该方法是Object 类的方法，所有的java对象都可以调用该方法
 * 3. 使用class 中的静态方法 forName(String className),该方法需要传入字符串参数，该字符串参数的值是某个类的全路径，也就是完整包名的路径
 */
public class ReflectDemo {
    public static void main(String args[]) throws ClassNotFoundException {
        //1.使用class类的属性来获取该类对应的Class 对象
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);

        // 1.使用class类的属性来获取该类对应的Class 对象
        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();

        System.out.println(c1 == c3);

        // 使用class 中的静态方法 forName(String className)
        Class<?> c4 = Class.forName("com.test01.Student");
        System.out.println(c1 == c4);

    }
}

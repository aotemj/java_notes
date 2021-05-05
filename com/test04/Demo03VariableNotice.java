package com.test04;

public class Demo03VariableNotice {
  public static void main(String[] args){
    // 注意事项1： 变量必须先赋值再使用否则报错：
    // int num1;
    // System.out.println(num1);
    // 注意事项2： 变量只在自己的作用域内有效，单个变量的作用域为从定义该变量开始，到最近的结束大括号为止
    int num1 = 100;
    System.out.println(num1);
    // 注意事项3: 变量可以批量赋值，但不建议这样做：
    int num2, num3, num4;
    num2 = 1;
    num3 = 2;
    num4 = 3;
    System.out.println(num2);
    System.out.println(num3);
    System.out.println(num4);

    int num5 = 20,num6 = 30,num7 = 40;
    System.out.println(num5);
    System.out.println(num6);
    System.out.println(num7);
  }
}
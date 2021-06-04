package com;

public class Demo02Variable {
  public static void main(String[] args){
    // int 变量
    int num1 = 10;
    System.out.println(num1);
    num1 -= 1;
    System.out.println(num1);
    // byte 变量
    byte num2 = 30;
    System.out.println(num2);
    num2 = 44;
    System.out.println(num2);
    // short 变量
    short num3 = 100;
    System.out.println(num3);
    num3 = 101;
    System.out.println(num3);

    //  long 变量
    long num4 = 3000000000L;
    System.out.println(num4);
    num4 = 2900000000L;
    System.out.println(num4);

    // float 变量
    float var1 = 0.111F;
    System.out.println(var1);
    var1 = 0.112F;
    System.out.println(var1);

    // double 变量
    double var2 = 0.22;
    System.out.println(var2);
    var2 = 0.1111;
    System.out.println(var2);

    //  char 变量
    char var3 = 'a';
    System.out.println(var3);
    var3 = '中';
    System.out.println(var3);

    // boolean 变量
    boolean bool1 = true;
    System.out.println(bool1); 
    bool1 = false;
    System.out.println(bool1);
  }
}
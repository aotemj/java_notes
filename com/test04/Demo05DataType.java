package com.test04;

public class Demo05DataType {
  public static void main(String[] args){
    // 强制类型转换
    // int num1 = 100L;
    // System.out.println(num1); // 不可以进行转换，因为会有丢失
    
    // 强制类型转换格式： 范围大的数据类型  变量名 = (范围小的数据类型) 值;

    int num2 = (int)100L;
    System.out.println(num2);

    // 注意事项：
    //  1. 日常使用中不推荐使用轻质类型转换，因为有可能发生数据溢出、或数据精度丢失
    //  2. byte/short/char 三种类型都可以发生数学运算 ，如 ”+“
    //  3. byte/short/char 在发生数学运算的时候都会首先被转换成int ,然后参与运算
    //  4. boolean 不可以参与类型转换

    int num3 = (int)6000000000L;
    System.out.println(num3); // 1705032704  超出了int 的数据范围，数据移除
    int num4 = (int)3.99; 
    System.out.println(num4); // 3 精度丢失

    byte num5 = 40;
    byte num6 = 30;
    // byte num7 = num5 + num6;
    // System.out.println(num7); // 报错，num5、num6 参与运算时都会转换成int ,int 转换成byte 有数据溢出
    int num7 = num5 + num6;
    System.out.println(num7); // 70 

    byte num8 = (byte)(num5 + num6); 
    System.out.println(num8); // 70 强制类型转换

    char num9 = 'A';
    int num10 = num9 +1; 
    System.out.println(num10); // 66
  }
}
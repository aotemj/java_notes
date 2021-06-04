package com;

public class Demo08Plus {
  public static void main (String[] args){
    /*
      java 中的加法：
        1. 加法运算符两边都是数值的时候执行普通的加法运算
        2. char 类型的数值参加运算时，会首先将char 类型提升为int类型，然后参与运算
        3. String 类型的值和一切 类型的值进行加法运算，都会进行 链接操作
    */ 
    char char1 = 'A';
    String str1 = "Hello";
    System.out.println(str1+10); // Hello10
    System.out.println(str1+ 10 + 1); // Hello101
    System.out.println(str1+char1); // HelloA
    
  }
}
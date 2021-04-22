public class Demo07Operator {
  public static void main (String[] args){
    /*
    算数运算符：
     +
     -
     *
     /
     %
      注意事项： 
        1. 如果运算符两边的数据类型不统一，将首先转换为数据范围大的数据类型，然后在进行运算
        2. 两个整数进行除法运算，结果为 商，不保存余数，如果要去余数，请使用取模运算： %
    */ 
    
    int num1 = 10;
    int num2 = 3;
    int result1 = num1 + num2;
    System.out.println(result1); // 13

    double num3 = 3.14;
    
    double result2 = num1 + num3;
    System.out.println(result2); // 13.14

    int result3 = num1/num2;
    System.out.println(result3); // 3
    int result4 = num1%num2;
    System.out.println(result4); // 1
    
    double result5 = num1/num3;
    System.out.println(result5);
  }
}
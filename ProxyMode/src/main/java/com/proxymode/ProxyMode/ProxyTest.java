package com.proxymode.ProxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //    1. 获取真实对象实例
        Lenovo l = new Lenovo();
        //    2.动态代理增强lenovo 对象
        SaleComputer proxyObject = (SaleComputer) Proxy.newProxyInstance(Lenovo.class.getClassLoader(), l.getClass().getInterfaces(), new InvocationHandler() {
            //           当前方法会在每次执行代理对象方法的时候被执行

            /**
             *
             * @param proxy     代理对象
             * @param method    代理对象调用的方法，被封装为的对象
             * @param args      代理对象调用方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("当前方法执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);
                if (method.getName().equals("sale")) {
                    //                增强参数：
                    double money = (double) args[0];
                    money *= 0.85;
                    Object obj = method.invoke(l, money);
                    return obj;
                } else {
//                使用真实参数调用该方法：
                    Object obj = method.invoke(l, args);
                    return obj;
                }
            }
        });
        proxyObject.sale(8000);
//        proxyObject.show();
//        l.sale(8000);

    }
}

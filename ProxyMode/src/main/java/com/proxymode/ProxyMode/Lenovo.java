package com.proxymode.ProxyMode;

/**
 * 代理的真实类
 */
public class Lenovo implements SaleComputer {
    @Override
    public void sale(double money) {
        System.out.println("花了" + money + "买了一台联想电脑");
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}

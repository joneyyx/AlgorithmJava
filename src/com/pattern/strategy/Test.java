package com.pattern.strategy;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/8 9:24 PM
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new CalculationAdd());
        System.out.println("10 + 5  = " + context.executeStrategy(10, 5));
    }
}

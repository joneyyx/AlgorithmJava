package com.pattern.strategy;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/8 9:22 PM
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.calculate(num1, num2);
    }
}

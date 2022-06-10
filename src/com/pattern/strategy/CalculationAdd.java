package com.pattern.strategy;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/8 9:20 PM
 */

public class CalculationAdd implements Strategy{

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

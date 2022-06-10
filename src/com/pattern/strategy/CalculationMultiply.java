package com.pattern.strategy;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/8 9:21 PM
 */
public class CalculationMultiply implements Strategy{
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

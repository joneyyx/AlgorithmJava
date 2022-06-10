package com.pattern.singleton;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/9 3:13 PM
 */
public class SingleObjectDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
//        SingleObject instance = new SingleObject();

        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();
    }
}

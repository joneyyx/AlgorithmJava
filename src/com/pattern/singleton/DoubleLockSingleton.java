package com.pattern.singleton;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/9 3:23 PM
 */
public class DoubleLockSingleton {
    private volatile static DoubleLockSingleton doubleLockSingleton;
    private DoubleLockSingleton(){};

    public static DoubleLockSingleton getSingleton(){
        if(doubleLockSingleton == null) {
            synchronized (DoubleLockSingleton.class) {
                if(doubleLockSingleton == null) {
                    doubleLockSingleton = new DoubleLockSingleton();
                }
            }
        }
        return doubleLockSingleton;
    }
}

package com.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/5/25 2:55 PM
 */

class NumberThread implements Runnable {

    @Override
    public void run() {
        for(int i =0; i < 1000 ; i ++) {
            if( i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for(int i =0; i < 1000 ; i ++) {
            if( i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        // 创建指定个数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println(executorService.getClass());

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

        // 执行指定线程的操作，需要实现提供Runnable接口偶着Callback接口实现类的对象
        NumberThread numberThread = new NumberThread(); // 适合RunnableThreadPoolExecutor
        executorService.execute(numberThread);
        executorService.execute(new NumberThread1());


//        executorService.submit()  // 适合使用Callable

        executorService.shutdown();

    }
}

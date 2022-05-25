package com.parallel;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/5/24 2:53 PM
 */
public class ParallelTest {
    private static long count = 0;
    private void add10k() {
        int idx = 0;
        while (idx++ <10000) {
            count += 1;
        }
    }
    public static long cal() throws InterruptedException {
        final ParallelTest test = new ParallelTest();
        Thread thread1 = new Thread(() -> {
            test.add10k();
        });
        Thread thread2 = new Thread(() -> {
            test.add10k();
        });
        // 启动两个线程
        thread1.start();
        thread2.start();
        // 等待两个线程结束
        thread1.join();
        thread2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        cal();
    }
}

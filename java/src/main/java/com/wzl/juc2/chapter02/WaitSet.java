package com.wzl.juc2.chapter02;

import java.util.stream.IntStream;

/**
 * @author: weizhenglong
 * @since 2018-04-02
 */
public class WaitSet {

    private static Object lock = new Object();

    public static void main(String[] args) {


        IntStream.range(1, 10).forEach((int i) -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println(i + "begin---" + Thread.currentThread() + "begin--" + "---");
                        try {
                            lock.wait();
                        } catch (Exception e) {
                        }
                        System.out.println(i + "end---" + Thread.currentThread() + "end--" + "---");
                    }

                }
            }).start();
        });
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }


        IntStream.range(1, 10).forEach((int i) -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println(i + "aaaaabegin---" + Thread.currentThread() + "begin--" + "---");
                        try {
                            lock.notify();
                        } catch (Exception e) {
                        }
                        System.out.println(i + "bbbbbend---" + Thread.currentThread() + "end--" + "---");
                    }

                }
            }).start();
        });
    }
}

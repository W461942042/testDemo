/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： FutureThreadPoolDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月15日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class FutureThreadPoolDemo {

  // Future编码缺点：阻塞

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 3个任务，目前开启多个异步任务线程来处理，请问耗时多少？
    long startTime = System.currentTimeMillis();
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    FutureTask futureTask1 = new FutureTask<String>(() -> {

      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "task1 over";
    });
    threadPool.submit(futureTask1);

    FutureTask futureTask2 = new FutureTask<String>(() -> {

      try {
        TimeUnit.MILLISECONDS.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "task2 over";
    });
    threadPool.submit(futureTask2);

    System.out.println(futureTask1.get());
    System.out.println(futureTask2.get());

    try {
      TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    threadPool.shutdown();

    long endTime = System.currentTimeMillis();
    System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");

  }

  private static void m1() {
    // 3个任务，只有一个线程main来处理，请问耗时多少？
    long startTime = System.currentTimeMillis();

    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();

    }

    long endTime = System.currentTimeMillis();
    System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");
    System.out.println(Thread.currentThread().getName() + "\t --- end");
  }

}
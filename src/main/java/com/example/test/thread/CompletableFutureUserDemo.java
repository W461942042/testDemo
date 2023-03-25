/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureUserDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureUserDemo {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    try {
      CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread().getName() + "--- come in ");
        int result = ThreadLocalRandom.current().nextInt(10);
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("---一秒后输出结果：" + result);
        return result;
      }, threadPool).whenComplete((v, e) -> {
        if (e == null) {
          System.out.println("计算完成，更新系统UpdateValue " + v);
        }
      }).exceptionally(e -> {
        e.printStackTrace();
        System.out.println("异常情况：" + e.getCause() + "\t" + e.getMessage());
        return null;
      });
      System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      threadPool.shutdown();
    }

    // 主线程不要立刻结束，否则CompletableFutrue默认使用的线程池会立刻关闭：暂停3秒钟线程
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // future1();
  }

  private static void future1() {

    CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "--- come in ");
      int result = ThreadLocalRandom.current().nextInt(10);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("---一秒后输出结果：" + result);
      return result;
    });

    System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
  }

}
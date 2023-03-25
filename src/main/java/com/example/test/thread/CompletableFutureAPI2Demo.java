/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureAPI2Demo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 对计算结果进行处理
 * thenApply 计算结果存在依赖关系，这两个线程串行化 异常相关：由于存在依赖关系（当前步骤错误，不走下一步），当前步骤有异常就叫停
 * handle 计算结果存在依赖关系，这两个线程串行化 异常相关： 有异常也可以往下一步走，根据带的异常参数可以进行下一步处理
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureAPI2Demo {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("111");
      return 1;
    }, threadPool).handle((f, e) -> {
      int i = 10 / 0;
      System.out.println("222");
      return f + 2;
    }).handle((f, e) -> {
      System.out.println("333");
      return f + 3;
    }).whenComplete((v, e) -> {
      if (e == null) {
        System.out.println("计算结果：" + v);
      }
    }).exceptionally(e -> {
      e.printStackTrace();
      System.out.println(e.getMessage());
      return null;
    });
    System.out.println(Thread.currentThread().getName() + "---主线程先去忙其他任务");

    threadPool.shutdown();

    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
    /*
     * try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {
     * e.printStackTrace(); }
     */
  }
}
/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： completableFutureBuildDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureBuildDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 没有指定Executor的方法，直接使用默认的ForkJoinPool.commonPool()作为它的线程池执行异步代码
    // 如果指定线程池，则使用我们自定义的或者特别指定的线程池执行异步代码。
    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    /*
     * CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->
     * { System.out.println(Thread.currentThread().getName()); try {
     * TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {
     * e.printStackTrace(); } }, threadPool);
     */

    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      return "hello supplyAsync";

    });
    System.out.println(completableFuture.get());
    threadPool.shutdown();
  }
}
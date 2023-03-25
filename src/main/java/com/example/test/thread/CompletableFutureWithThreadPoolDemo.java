/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureWithThreadPoolDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月21日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureWithThreadPoolDemo {

  // 1.没有传入自定义线程池，都用默认线程池ForkJoinPool
  // 2.传入了一个自定义线程池,如果你执行第一个任务时，传入了一个自定义线程池：
  // 调用thenRun方法执行第二个任务时，则第二个任务和第一个任务是共用同一个线程池
  // 调用thenRunAsync执行第二个任务是，则第一个任务使用的是你自己传入的线程池，第二个任务使用的是ForkJoin线程池
  // 3.有可能处理太快，系统优化切换原则，直接使用main线程处理

  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(5);

      CompletableFuture.supplyAsync(()->{
          try {
              TimeUnit.MILLISECONDS.sleep(20);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("1号任务" + "\t" + Thread.currentThread().getName());
          return "abcd";
      },threadPool).thenRun(()->{
          try {
              TimeUnit.MILLISECONDS.sleep(20);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("2号任务" + "\t" + Thread.currentThread().getName());
      }).thenRunAsync(()->{
          try {
              TimeUnit.MILLISECONDS.sleep(10);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("3号任务" + "\t" + Thread.currentThread().getName());
      });
     threadPool.shutdown();
  }

}

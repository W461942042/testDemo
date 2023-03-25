/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureCombineDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月21日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureCombineDemo {

  public static void main(String[] args) {
    CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "---启动");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return 10;
    });

    CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "---启动");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return 20;
    });

    CompletableFuture<Integer> result = completableFuture1.thenCombine(completableFuture2,
        (x, y) -> {
          System.out.println("---开始两个结果合并");
          return x + y;
        });

    System.out.println(result.join());
  }
}
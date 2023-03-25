/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureAPIDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 获得结果和触发计算
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureAPIDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "abc";
    });
    // System.out.println(completableFuture.get());
    // System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
    // System.out.println(completableFuture.join());
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 没有计算完成的时候，给一个替代结果
    // 立即获取结果不阻塞
    // System.out.println(completableFuture.getNow("XXX"));

    System.out
        .println(completableFuture.complete("completeValue") + "\t" + completableFuture.join());
  }
}
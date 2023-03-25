/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableAPI3Demo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.CompletableFuture;

/**
 * 对计算结果进行消费
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableAPI3FutureDemo {
  public static void main(String[] args) {
    /*
     * CompletableFuture.supplyAsync(() -> { return 1; }).thenApply(f -> { return f
     * + 2; }).thenApply(f -> { return f + 3; }).thenAccept(System.out::println);
     */

    System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {
    }).join());
    // 消费型的方法
    System.out.println(CompletableFuture.supplyAsync(() -> "resultA")
        .thenAccept(r -> System.out.println(r)).join());
    System.out.println(
        CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());
  }
}

// thenRun 任务A执行完执行B，并且B不需要A的结果
// thenAccept 任务A执行完执行B，B需要A的结果，但是任务B无返回值
// thenApply 任务A执行完执行B，B需要A的结果，同时任务B有返回值
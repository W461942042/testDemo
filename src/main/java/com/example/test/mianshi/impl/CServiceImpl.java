/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CServiceImpl.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CServiceImpl implements CService {
  @Autowired
  AService aService;
  @Autowired
  BService bService;
  @Override
  public Integer get() {
    CompletableFuture<Integer> futureA = CompletableFuture.supplyAsync(() -> get(), aService);
    CompletableFuture<Integer> futureB = CompletableFuture.supplyAsync(() -> get(), bService);
    CompletableFuture<Void> allOf = CompletableFuture.allOf(futureA, futureB);

    try {
      allOf.get();
      Integer sum = futureA.get() + futureB.get();
      return sum;

    } catch (InterruptedException exception) {

    } catch (ExecutionException exception) {

    } finally {
      aService.shutdown();
      bService.shutdown();
    }
    return null;
  }
}
/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Test.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class LeanCompletableFuture {
  static ExecutorService executorService = Executors.newFixedThreadPool(7);

  public static Map dataStatisticsParallel() {

    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> countUserNum(),
        executorService);
    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> countCompanyNum(),
        executorService);
    CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> countWorkNum(),
        executorService);
    CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> countTaskNum(),
        executorService);
    CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> countCourseNum(),
        executorService);
    CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> countMissonNum(),
        executorService);
    CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> countLoginNum(),
        executorService);

    CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3, future4,
        future5, future6, future7);
    try {
      allOf.get();

      Map<String, Object> data = new HashMap<>();
      data.put("userNum", future1.get());
      data.put("companyNum", future2.get());
      data.put("workNum", future3.get());
      data.put("taskNum", future4.get());
      data.put("courseNum", future5.get());
      data.put("missionNum", future6.get());
      data.put("loginNum", future7.get());

      return data;

    } catch (InterruptedException exception) {

    } catch (ExecutionException exception) {

    } finally {
      executorService.shutdown();
    }

    return null;
  }

  public static void main(String[] args) {

    System.out.println("---串行开始----");

    long start = System.currentTimeMillis();
    Map map = dataStatistics();

    map.forEach((key, value) -> System.out.println(key + ":" + value));

    long end = System.currentTimeMillis();

    map.forEach((key, value) -> System.out.println(key + ":" + value));
    System.out.println("---串行结束-- 耗时--" + (end - start));

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("---并行开始----");
    long start1 = System.currentTimeMillis();
    Map map1 = dataStatisticsParallel();

    long end1 = System.currentTimeMillis();
    map1.forEach((key, value) -> System.out.println(key + ":" + value));
    System.out.println("---并行结束-- 耗时--" + (end1 - start1));

  }

  /**
   * 首页大屏数据统计，每个模拟耗时1秒
   *
   * @return
   */
  public static Map dataStatistics() {
    Map<String, Object> data = new HashMap<>();
    data.put("userNum", countUserNum());
    data.put("companyNum", countCompanyNum());
    data.put("workNum", countWorkNum());
    data.put("taskNum", countTaskNum());
    data.put("courseNum", countCourseNum());
    data.put("missionNum", countMissonNum());
    data.put("loginNum", countLoginNum());

    return data;
  }

  private static Integer countLoginNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    Integer countLoginNum = new Random().nextInt(1000);
    return countLoginNum == null ? 0 : countLoginNum * 5;
  }

  private static Integer countMissonNum() {

    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    Integer countMissonNum = new Random().nextInt(1000);
    return countMissonNum == null ? 0 : countMissonNum;
  }

  private static Integer countCourseNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    Integer countCourseNum = new Random().nextInt(1000);
    return countCourseNum == null ? 0 : countCourseNum;
  }

  private static Integer countTaskNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    Integer countTaskNum = new Random().nextInt(1000);
    return countTaskNum == null ? 0 : countTaskNum;
  }

  private static Integer countWorkNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    Integer countWorkNum = new Random().nextInt(1000);
    return countWorkNum == null ? 0 : countWorkNum;
  }

  private static Integer countCompanyNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }

    Integer countCompanyNum = new Random().nextInt(1000);
    return countCompanyNum == null ? 0 : countCompanyNum;
  }

  private static Integer countUserNum() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }

    Integer countUserNum = new Random().nextInt(1000);
    return countUserNum == null ? 0 : countUserNum;
  }

}
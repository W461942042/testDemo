/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureMallDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月19日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureMallDemo {

  static List<NetMall> list = Arrays.asList(new NetMall("jd"), new NetMall("dangdang"),
      new NetMall("taobao"));

  /**
   * 一步一步查
   * 
   * List<NetMall> -> Map -> List<String>
   * 
   * @param list
   * @param produceName
   * @return
   */
  public static List<String> getPrice(List<NetMall> list, String produceName) {
    return list.stream().map(netMall -> String.format(produceName + " in %s price is %.2f ",
        netMall.getNetMallName(), netMall.calcPrice(produceName))).collect(Collectors.toList());
  }

  /**
   * List<NetMall> -> ? -> List<String>
   * 
   * @param list
   * @param produceName
   * @return
   */
  public static List<String> getPriceByCompletableFuture(List<NetMall> list, String produceName) {
    return list.stream()
        .map(netMall -> CompletableFuture
            .supplyAsync(() -> String.format(produceName + " in %s price is %.2f ",
                netMall.getNetMallName(), netMall.calcPrice(produceName))))
        .collect(Collectors.toList()).stream().map(s -> s.join()).collect(Collectors.toList());

  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
  /*  List<String> list1 = getPrice(CompletableFutureMallDemo.list, "mysql");
    for (String element : list1) {
      System.out.println(element);
    }*/

    List<String> list2 = getPriceByCompletableFuture(CompletableFutureMallDemo.list, "mysql");
    for (String element : list2) {
      System.out.println(element);
    }

    long endTime = System.currentTimeMillis();
    System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");

  }
}

class NetMall {
  @Getter
  private String netMallName;

  public NetMall(String netMallName) {
    this.netMallName = netMallName;
  }

  public double calcPrice(String produceName) {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return ThreadLocalRandom.current().nextDouble() * 2 + produceName.charAt(0);
  }

}
/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： interruptApiDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月28日 - wanghuanyu - 创建。
 */
package com.example.test.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class interruptDemo2 {
  // 实例方法interrupt()仅仅是设置线程的中断状态位设置为true,不会停止线程
  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      for (int i = 1; i < 300; i++) {
        System.out.println("----" + i);
      }
    }, "t1");
    t1.start();
    System.out.println("t1线程默认的中断标识：" + t1.isInterrupted());// false 
    try {
      TimeUnit.MILLISECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t1.interrupt();// true
    System.out.println("t1线程调用中断方法后的中断标识01：" + t1.isInterrupted());

    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t1.interrupt();// true
    System.out.println("t1线程调用中断方法后的中断标识02：" + t1.isInterrupted());
  }
}
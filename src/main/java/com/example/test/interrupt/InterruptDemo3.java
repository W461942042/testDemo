/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： InterruptDemo3.java
 * 模块说明：
 * 修改历史：
 * 2023年03月29日 - wanghuanyu - 创建。
 */
package com.example.test.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class InterruptDemo3 {
  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      while (true) {
        if (Thread.currentThread().isInterrupted()) {
          System.out.println(Thread.currentThread().getName() + "\t 中断标志位："
              + Thread.currentThread().isInterrupted() + "程序停止");
          break;
        }
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();//为什么要在异常处，再调用一次？？
          e.printStackTrace();
        }
        System.out.println("----hello InterruptDemo03");
      }
    }, "t1");

    t1.start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(() -> t1.interrupt(), "t2").start();

  }
}
//中断只是一种协商机制，修改中断标识位仅此而已，而不是立刻stop打断

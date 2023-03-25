/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： SaleTicketDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月24日 - wanghuanyu - 创建。
 */
package com.example.test.threadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wanghuanyu
 * @since 1.0
 */
class Ticket {// 资源类，模拟3个售票员卖完50张票
  private int number = 50;
  ReentrantLock lock = new ReentrantLock(true);

  public void sale() {
    lock.lock();
    try {
      if (number > 0) {
        System.out.println(Thread.currentThread());
      }
    } finally {
      lock.unlock();
    }

  }
}

public class SaleTicketDemo {
  public static void main(String[] args) {
    Ticket ticket = new Ticket();
    new Thread(() -> {
      for (int i = 0; i < 55; i++) {
        ticket.sale();
      }
    }, "a").start();
    new Thread(() -> {
      for (int i = 0; i < 55; i++) {
        ticket.sale();
      }
    }, "b").start();
    new Thread(() -> {
      for (int i = 0; i < 55; i++) {
        ticket.sale();
      }
    }, "c").start();
  }
}
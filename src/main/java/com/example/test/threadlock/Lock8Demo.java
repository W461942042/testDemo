/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： SaleTicketDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月23日 - wanghuanyu - 创建。
 */
package com.example.test.threadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Lock8Demo {

  public static void main(String[] args) {
    Phone phone = new Phone();
    Phone phone2 = new Phone();
    new Thread(() -> {
      phone.sendEMail();
    }, "a").start();

    // 暂停毫秒，保证a线程启动
    try {
      TimeUnit.MILLISECONDS.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(() -> {
      // phone.hello();
      // phone.sendSMS();
      phone2.sendSMS();
    }, "b").start();

  }
}

class Phone {// 资源类
  public synchronized void sendEMail() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("---sendEMail");
  }

  public synchronized void sendSMS() {
    System.out.println("---sendSMS");
  }

  public void hello() {
    System.out.println("---hello");
  }
}
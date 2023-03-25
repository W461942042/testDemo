/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： DaemonDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月15日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class DaemonDemo {

  public static void main(String[] args) {// main方法是经典的一个用户线程，GC垃圾回收线程是典型的一个守护线程

    Thread t1 = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + "\t 开始运行，"
          + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
      while (true) {

      }
    }, "t1");

    t1.setDaemon(true);
    t1.start();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName() + "\t ---end 主线程");
  }
}

// 如果用户线程全部结束意味着程序需要完成的业务操作已经结束，守护线程会随着JVM一同结束工作
// setDaemon(true)方法必须在start()之前设置，否则报IllegalThreadStateException，不能把正常运行的线程设置为守护线程
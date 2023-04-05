/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： InterruptDemp.java
 * 模块说明：
 * 修改历史：
 * 2023年03月28日 - wanghuanyu - 创建。
 */
package com.example.test.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class InterruptDemo {
  static volatile boolean isStop = false;
  static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

  public static void main(String[] args) {
    // 使用Thread类自带的中断api实例方法实现
    Thread t1 = new Thread(() -> {
      while (true) {
        if (Thread.currentThread().isInterrupted()) {
          System.out
              .println(Thread.currentThread().getName() + "\t isInterrupted() 被修改为true,程序停止 ");
          break;
        }
        System.out.println("t1 --- hello Interrupt api");
      }
    }, "t1");
    t1.start();
    System.out.println("t1的默认中断标志位：" + t1.isInterrupted());
    try {
      TimeUnit.MILLISECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Thread t2 = new Thread(() -> {
      t1.interrupt();
    }, "t2");
    t2.start();
  }

  private static void m2() {
    new Thread(() -> {
      while (true) {
        if (atomicBoolean.get()) {
          System.out.println(Thread.currentThread().getName() + "\t atomicBoolean 被修改为true,程序停止 ");
          break;
        }
        System.out.println("hello atomicBoolean");
      }
    }, "t1").start();

    try {
      TimeUnit.MILLISECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> {
      atomicBoolean.set(true);
    }, "t2").start();
  }

  private static void m1() {
    new Thread(() -> {
      while (true) {
        if (isStop) {
          System.out.println(Thread.currentThread().getName() + "\t isStop 被修改为true,程序停止 ");
          break;
        }
        System.out.println("hello volatile");
      }
    }, "t1").start();

    try {
      TimeUnit.MILLISECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> {
      isStop = true;
    }, "t2").start();
  }

}
// kill stop...
// 一个线程不应该由其他线程来强制中断或停止，而是应该由线程自己自行停止，自己来决定自己的命运
// 所以，Thread.stop, Thread.suspend, Thread.resume都已经被废弃了
// 在Java中没有办法立即停止一条线程，然而停止线程却显得尤为重要，如取消一个耗时操作
// 因此，Java提供了一种用于停止线程的协商机制-中断，也即中断标识协商机制。
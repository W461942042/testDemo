/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： LockSupportDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年04月03日 - wanghuanyu - 创建。
 */
package com.example.test.threadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class LockSupportDemo {

  public static void main(String[] args) {
    Object objectLock = new Object();
    new Thread(() -> {
      synchronized (objectLock) {
        System.out.println(Thread.currentThread().getName() + "\t ---come in");
        try {
          objectLock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t ---被唤醒");
      }
    }, "t1").start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(() -> {
      synchronized (objectLock) {
        objectLock.notify();
        System.out.println(Thread.currentThread().getName() + "\t ---发出通知");
      }
    }, "t2").start();
  } 
}
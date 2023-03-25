/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ThreadBaseDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月15日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class ThreadBaseDemo {

  public static void main(String[] args) {
    Object o = new Object();
    Thread t1 = new Thread(() -> {
      synchronized (o) {
        System.out.println("我t1拿到锁了");
      }
    }, "t1");
    t1.start();
    new Thread(() -> {
      synchronized (o) {
        System.out.println("我t2拿到锁了");
      }
    }, "t2").start();
  }
}

// Java语言本身底层就是C++语言
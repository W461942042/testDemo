/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： LockSyncDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月23日 - wanghuanyu - 创建。
 */
package com.example.test.threadlock;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class LockSyncDemo {
  Object object = new Object();

  public void m1() {
    synchronized (object) {
      System.out.println("hello synchronized code block");
    }
  }

  public static void main(String[] args) {

  }
}
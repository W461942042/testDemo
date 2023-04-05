/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： InterruptDemo4.java
 * 模块说明：
 * 修改历史：
 * 2023年03月29日 - wanghuanyu - 创建。
 */
package com.example.test.interrupt;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class InterruptDemo4 {
  // 测试当前线程是否被中断（检查中断标志），返回一个boolean并清除中断状态，
  // 第二次再调用时，中断状态已经被清楚，返回一个false
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    System.out.println("--- 1");
    Thread.currentThread().interrupt();// 中断标志位设置为true
    System.out.println(Thread.currentThread().getName() + "\t " + Thread.interrupted());
    System.out.println(Thread.currentThread().getName() + "\t " + Thread.interrupted());

    Thread.interrupted();//静态方法
  }
}
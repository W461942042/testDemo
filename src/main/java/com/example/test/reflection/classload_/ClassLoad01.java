/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ClassLoad01.java
 * 模块说明：
 * 修改历史：
 * 2022年11月05日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.classload_;

/**
 * @author wanghuanyu
 * @since 1.0 说明一个类加载的链接阶段
 */
public class ClassLoad01 {
  public static void main(String[] args) {

  }
}

class A {
  // 属性-成员变量-字段
  // 分析类加载的链接阶段-准备，属性是如何处理的
  // 1.n1是实例属性，不是静态变量，因此在准备阶段，是不会分配内存的
  // 2.n2是静态变量，分配内存n2是默认初始化0，而不是20
  // 3.n3是static final 是常量。和静态变量不一样，因为一旦赋值就不变 n3 = 30
  public int n1 = 10;
  public static int n2 = 20;
  public static final int n3 = 30;
}
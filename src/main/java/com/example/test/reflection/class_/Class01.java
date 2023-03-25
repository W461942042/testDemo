/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Class01.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.class_;

import com.pojo.Cat;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Class01 {
  public static void main(String[] args) throws ClassNotFoundException {
    // Class类的类图
    // 1.Class也是类，因此也继承Object
    // 2.Class类不是new出来的，而是系统创建的

    // （1）传统new对象
    Cat cat = new Cat();

    //（2）反射的方式
      Class cls1 = Class.forName("com.pojo.Cat");

      //3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
      Class cls2 = Class.forName("com.pojo.Cat");
      System.out.println(cls1.hashCode());
      System.out.println(cls2.hashCode());
      Class cls3 = Class.forName("com.pojo.Dog");
      System.out.println(cls3.hashCode());
  }

  //4.通过Class对象可以完整地得到一个类的完整结构，通过一系列API


}
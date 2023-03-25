/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ClassLoad02.java
 * 模块说明：
 * 修改历史：
 * 2022年11月05日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.classload_;

import java.lang.reflect.Field;

/**
 * @author wanghuanyu
 * @since 1.0 演示类加载-初始化加载
 */
public class ClassLoad02 {
  public static void main(String[] args) throws ClassNotFoundException {
    // 分析
    // 1.加载B类，并生成B的class对象
    // 2.连接 num = 0
    // 3.初始化阶段
    // 依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句
    /*
     * clinit(){ System.out.println("B 静态代码块被执行"); num = 300; num = 100; } 合并：num =
     * 100；
     */
    // 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地执行加多、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，知道活动线程执行完毕
    new B();// 类加载
    System.out.println(B.num);

    Class<?> b = Class.forName("com.pojo.Car");
    Field[] declaredFields = b.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      System.out.println("本类中所有的属性：" + declaredField.getName() +"改属性的修饰符=" +declaredField.getModifiers());
    }
  }
}

class B {
  static {
    System.out.println("B 静态代码块被执行");
    num = 300;
  }
  static int num = 100;

  public B() {
    System.out.println("构造器被执行");
  }
}
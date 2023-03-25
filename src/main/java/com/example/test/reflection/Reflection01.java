/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ReflectionQuestion.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.example.test.reflection;

import com.pojo.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wanghuanyu
 * @since 1.0 测试反射调用的性能和优化方案
 *
 */
public class Reflection01 {

  public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
      InstantiationException, NoSuchMethodException, IllegalAccessException {
    m1();
    m2();
    m3();
  }

  // 传统方法调用hi
  public static void m1() {
    Cat cat = new Cat();
    long start = System.currentTimeMillis();
    for (int i = 0; i < 90000000; i++) {
      cat.hi();
    }
    long end = System.currentTimeMillis();
    System.out.println("传统方法来调用hi，耗时=" + (end - start));
  }

  // 使用反射机制调用方法
  public static void m2() throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    Class cls = Class.forName("com.pojo.Cat");
    Object o = cls.newInstance();
    Method hi = cls.getMethod("hi");

    long start = System.currentTimeMillis();
    for (int i = 0; i < 90000000; i++) {
      hi.invoke(o);// 反射机制调用
    }
    long end = System.currentTimeMillis();
    System.out.println("反射机制来调用hi，耗时=" + (end - start));
  }

  // 反射调用优化 + 关闭访问检查
  public static void m3() throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    Class cls = Class.forName("com.pojo.Cat");
    Object o = cls.newInstance();
    Method hi = cls.getMethod("hi");
    hi.setAccessible(true);// 取消在反射调用方法时，取消调用检查

    long start = System.currentTimeMillis();
    for (int i = 0; i < 90000000; i++) {
      hi.invoke(o);// 反射机制调用
    }
    long end = System.currentTimeMillis();
    System.out.println("反射机制来调用hi，耗时=" + (end - start));
  }

  public void api_02() {

  }
}
/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ReflectCreateInstance.java
 * 模块说明：
 * 修改历史：
 * 2022年11月05日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.classload_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class ReflectCreateInstance {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, NoSuchMethodException, InvocationTargetException {
    // 1.先获取Car类的Class对象
    Class<?> catClass = Class.forName("com.pojo.Cat");
    // 2.通过public的无参构造器创建实例
    Object o = catClass.newInstance();
    System.out.println(o);
    // 3.通过public的有参构造器创造实例
    // 4.先得到对应构造器
    Constructor<?> constructor = catClass.getConstructor(String.class);
    Object why = constructor.newInstance("why");
    System.out.println("why:=" + why);
    // 5.暴破，使用反射可以访问private构造器，反射面前一切都是纸老虎
    Constructor<?> constructor1 = catClass.getConstructor(Integer.class, String.class);
    constructor1.setAccessible(true);
    Object user2 = constructor1.newInstance(100, "王环宇");
    System.out.println("user2=:" + user2);
  }
}
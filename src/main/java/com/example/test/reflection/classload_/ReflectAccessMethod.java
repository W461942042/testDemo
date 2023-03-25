/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ReflectAccessMethod.java
 * 模块说明：
 * 修改历史：
 * 2022年11月09日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.classload_;

import java.lang.reflect.Method;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class ReflectAccessMethod {
  public static void main(String[] args)
          throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
    // 1.得到Boss类对应的Class对象
    Class<?> bossCls = Class.forName("com.example.test.reflection.classload_.Boss");
    // 2.创建对象
    Object o = bossCls.newInstance();
    // 3.调用public的hi方法
      Method hi = bossCls.getMethod("hi");
  }

}

class Boss {
  public int age;
  private static String name;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static String getName() {
    return name;
  }

  public static void setName(String name) {
    Boss.name = name;
  }
}
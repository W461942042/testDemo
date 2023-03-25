/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： GetClass_.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.class_;

import com.pojo.Car;

/**
 * @author wanghuanyu
 * @since 1.0 演示得到Class对象的各种方式
 */
public class GetClass_ {

  public static void main(String[] args) throws ClassNotFoundException {
    // 1.Class.forName
    String clsAllPath = "com.pojo.Car";
    Class<?> cls1 = Class.forName(clsAllPath);
    System.out.println(cls1);

    // 2.类名.class，应用场景：多用于参数传递
    Class<Car> cls2 = Car.class;
    System.out.println(cls2);

    // 3.对象.class，应用场景：有对象实例
    Car car = new Car();
    Class cls3 = car.getClass();
    System.out.println(cls3);

    // 4.通过类加载器来湖区到类的Class对象 【4种】来获取到类的class对象
    // （1）先得到类加载器 car
    ClassLoader classLoader = car.getClass().getClassLoader();
    // (2) 通过类加载器得到Class对象
    Class cls4 = classLoader.loadClass(clsAllPath);
    System.out.println(cls4);

    System.out.println(cls1.hashCode());
    System.out.println(cls2.hashCode());
    System.out.println(cls3.hashCode());
    System.out.println(cls4.hashCode());

    //5.基本数据类型得到class类对象
      Class<Integer> integerClass = int.class;
      Class<Character> characterClass = char.class;
      Class<Boolean> booleanClass = boolean.class;
      System.out.println(integerClass);

      //6.基本数据类型对应的包装类，可以通过.type得到class类对象
      Class<Integer> type1 = Integer.TYPE;
      Class<Character> type2 = Character.TYPE;
      System.out.println(type1);

      System.out.println(integerClass.hashCode());
      System.out.println(type1.hashCode());
  }

}
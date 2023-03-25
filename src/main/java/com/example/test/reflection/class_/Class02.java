/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Class02.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.example.test.reflection.class_;

import com.pojo.Car;

import java.lang.reflect.Field;

/**
 * @author wanghuanyu
 * @since 1.0 Class类的常用方法
 */
public class Class02 {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, NoSuchFieldException {
    String classAllPath = "com.pojo.Car";

    // 1.获取到car类对应的Class对象
    // <?>表示不确定的Java类型
    Class<?> cls = Class.forName(classAllPath);

    // 2.输出cls
    System.out.println(cls);// 显示cls对象，是哪个类的Class对象 com.pojo.Car
    System.out.println(cls.getClass());// 输出cls运行类型 java.lang.class

    // 3.得到包名
    System.out.println(cls.getPackage().getName());

    // 4.得到类名
    System.out.println(cls.getName());

    // 5.通过cls创建对象实例
    Car car = (Car) cls.newInstance();
    System.out.println(car);// car.toString()

    // 6.通过反射获取属性
    Field brand = cls.getField("brand");
    System.out.println(brand.get(car));// 宝马

    // 7.通过反射给属性赋值
    brand.set(car, "奔驰");
    System.out.println(brand.get(car));

    //8.遍历得到所有的属性
      Field[] fields = cls.getFields();
      for (Field field : fields) {
          System.out.println(field.getName());//名称
      }

  }
}
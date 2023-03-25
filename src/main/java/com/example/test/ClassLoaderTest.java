/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： ClassLoaderTest.java
 * 模块说明：
 * 修改历史：
 * 2022年08月07日 - wanghuanyu - 创建。
 */
package com.example.test;

/**
 * 类的加载器
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class ClassLoaderTest {

  public static void main(String[] args) {
    // 获取系统类加载器
    ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
    System.out.println(sysClassLoader);

    // 获取其上层：扩展类加载器
    ClassLoader extClassLoader = sysClassLoader.getParent();
    System.out.println(extClassLoader) ;

    // 获取其上层
    ClassLoader bootStrapClassLoader = extClassLoader.getParent();
    System.out.println(bootStrapClassLoader);

    // 对于用户自定义类来说:默认使用系统类加载器进行加载
    ClassLoader classLoaderTest = ClassLoaderTest.class.getClassLoader();
    System.out.println(classLoaderTest);

    ClassLoader classLoader1 = String.class.getClassLoader();
    System.out.println(classLoader1);

  }
}
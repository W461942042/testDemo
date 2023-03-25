/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Cat.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.pojo;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Cat {
  private String name = "招财猫";
  public Integer age = 10;

  public Cat(String name) {
    this.name = name;
  }

  public Cat(Integer age, String name) {
    this.name = name;
  }

  public Cat() {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void hi() {
    // System.out.println("hi" + name);
  }

  public void cry() {
    System.out.println(name + "喵喵叫。。");
  }

  @Override
  public String toString() {
    return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
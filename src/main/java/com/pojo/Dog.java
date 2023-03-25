/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Dog.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package com.pojo;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Dog {
  private String name = "狗狗";
  private Integer age = 6;

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
}
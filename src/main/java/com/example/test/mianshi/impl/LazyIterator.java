/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： LazyIterator.java
 * 模块说明：
 * 修改历史：
 * 2023年05月06日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi.impl;

import java.util.Iterator;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class LazyIterator<T> implements Iterable<T> {
  private final ValueLoader valueLoader;

  // 待补充
  @Override
  public Iterator<T> iterator() {
    return new Itr();
  }

  public LazyIterator(ValueLoader valueLoader) {
    this.valueLoader = valueLoader;
  }

  private class Itr implements Iterator<T> {
    // 待补充
  }

}
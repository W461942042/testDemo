/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： AServiceImpl.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class AServiceImpl implements AService {
    @Autowired
    //AServiceRepository repository;

    public List<Integer> getA(List<Integer> ids) {
      return null;
    }

    @Override
    public Integer get() {
      return null;
    }
}
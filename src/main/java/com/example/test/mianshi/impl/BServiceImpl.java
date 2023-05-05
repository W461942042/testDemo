/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： BserviceImpl.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class BServiceImpl implements BService {
  @Autowired
  AService service;

  @Override
  public List<Integer> get(List<Integer> ids) {
    if (ids.size() >= 100) {
      throw new RuntimeException("最多支持传入100个id");
    }
    int size = ids.size();
    int total = size / 10;
    List<List<Integer>> splitList = new ArrayList<List<Integer>>();

    if (total == 0) {
      splitList.add(ids);
    } else {
      Map<Integer, List<Integer>> groups = ids.stream()
          .collect(Collectors.groupingBy(s -> (s - 1) / 3));
      for (List<Integer> list : groups.values()) {
        splitList.add(list);
      }
    }
    List<Integer> result = new ArrayList<>();

    for (List<Integer> integers : splitList) {
      List<Integer> target = service.getA(integers);
      result.addAll(target);
    }
    return result;
  }
}
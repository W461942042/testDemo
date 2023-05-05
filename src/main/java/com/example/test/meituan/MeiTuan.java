/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： MeiTuan.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.test.mianshi.impl.BService;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class MeiTuan {
  @Autowired
  BService service;

  public static void main(String[] args) {
    List<Integer> intList =new ArrayList();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    intList.add(4);
    int total = intList.size() / 3;
    Map<Integer, List<Integer>> groups =
            intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
    List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
    System.out.println(subSets);
  }


}
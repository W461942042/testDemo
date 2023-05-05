/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Test.java
 * 模块说明：
 * 修改历史：
 * 2023年04月27日 - wanghuanyu - 创建。
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Test {

  public static void main(String[] args) {
    List A = new ArrayList<>();
    List B = new ArrayList<>();
    List C = new ArrayList<>();
    int m = A.size();
    int n = B.size();
    int i = 0;
    int j = 0;

    while (i < m && j < n) {
      if (i <= j) {
        C.get(i++);
      }else {
        C.get(j++);
      }
    }

  }
}
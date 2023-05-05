/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： BinarySearch.java
 * 模块说明：
 * 修改历史：
 * 2023年04月17日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi;

/**
 * 二分查找算法
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] array = {
        1, 4, 7, 9, 10, 44, 78, 101, 203, 500 };
    int index = binarySearch(array, 203);
    System.out.println(index);
  }

  private static int binarySearch(int[] array, int x) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (x == array[middle]) {
        return middle;
      } else if (x < array[middle]) {
        high = middle - 1;
      } else {
        low = middle + 1;
      }
    }

    return -1;

  }
}
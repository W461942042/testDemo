/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： LengthOfLongestSubstring.java
 * 模块说明：
 * 修改历史：
 * 2022年11月09日 - wanghuanyu - 创建。
 */
package com.example.leeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author wanghuanyu
 * @since 1.0
 */
public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int end = 0, start = 0; end < n; end++) {
      char alpha = s.charAt(end);
      if (map.containsKey(alpha)) {
        start = Math.max(map.get(alpha), start);
      }
      ans = Math.max(ans, end - start + 1);
      map.put(s.charAt(end), end + 1);
    }
    return ans;
  }

}
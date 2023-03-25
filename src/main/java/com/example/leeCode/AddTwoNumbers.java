/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： AddTwoNumbers.java
 * 模块说明：
 * 修改历史：
 * 2022年11月09日 - wanghuanyu - 创建。
 */
package com.example.leeCode;

/**
 * 两数相加
 * 
 * @author wanghuanyu
 * @since 1.0
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(3);
    ListNode l2 = new ListNode(4, l1);
    ListNode l3 = new ListNode(2, l2);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(6, l4);
    ListNode l6 = new ListNode(5, l5);
    addTwoNumbers(l3, l6);

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(0);
    ListNode cur = pre;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = l1 == null ? 0 : l1.val;
      int y = l2 == null ? 0 : l2.val;
      int sum = x + y + carry;

      carry = sum / 10;
      sum = sum % 10;
      cur.next = new ListNode(sum);
      cur = cur.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry == 1) {
      cur.next = new ListNode(carry);
    }
    return pre.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
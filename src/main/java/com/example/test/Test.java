/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： Test.java
 * 模块说明：
 * 修改历史：
 * 2022年03月05日 - wanghuanyu - 创建。
 */
package com.example.test;

import java.text.ParseException;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class Test {

  public static void main(String[] args) throws ParseException {
    String inCode = "    {\"Result\":{\"ResponseStatus\":{\"ErrorCode\":500,\"IsSuccess\":false,\"Errors\":[{\"FieldName\":\"AbstractInteractionResult\",\"Message\":\"更新库存时出现可以忽略的异常数据，是否继续？\",\"DIndex\":0}],\"SuccessEntitys\":[],\"SuccessMessages\":[],\"MsgCode\":11}\n";//T1234000200022030815514900000035  220401180720
    /*Date date =  new SimpleDateFormat( "yyyyMMddHHmmss").parse(inCode);
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
    String datestr = sdf.format(date);*/
    System.out.println(inCode.length());
  }

  public static final String code128(String inCode, int len) {
    if (len % 2 != 0) {
      throw new RuntimeException("使用CODE128校验码，长度必须为偶数");
    }

    String outCode = inCode.trim();
    if (outCode.length() < len - 1) {
      String fillStr = "";
      for (int i = 0; i < len - 1 - inCode.length(); i++) {
        fillStr = fillStr + "0";
      }
      outCode = fillStr + outCode;
    } else {
      outCode = inCode.substring(0, len - 1);
    }
    outCode = '0' + inCode;
    int sum1 = 0;
    int sum2 = 0;
    int i = outCode.length();

    while (i >= 2) {
      sum1 = sum1 + (outCode.charAt(i - 1) - '0');
      sum2 = sum2 + (outCode.charAt(i - 2) - '0');
      i -= 2;
    }
    return outCode.substring(1, len) + (char) ('0' + (sum1 + sum2 * 3) % 10);
  }
}
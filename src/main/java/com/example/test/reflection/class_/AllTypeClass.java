/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2022，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： AllTypeClass.java
 * 模块说明：
 * 修改历史：
 * 2022年08月28日 - wanghuanyu - 创建。
 */
package
        com.example.test.reflection.class_;

import java.io.Serializable;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class; //外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注解
        //枚举
        Class<Thread.State> cls6 = Thread.State.class;
        //基本数据类型
        Class<Long> cls7 = long.class;
        Class<Void> cls8 = void.class;
        Class<Class> cls9 = Class.class;

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);


    }
}
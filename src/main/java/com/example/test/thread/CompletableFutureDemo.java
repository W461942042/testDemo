/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： CompletableFutureDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月15日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class CompletableFutureDemo {
  // Future是Java5新加的一个接口，它提供了一种异步并行计算的功能
  // 如果主线程需要执行一个很耗时的计算任务，我们就可以通过future把这个任务放到异步线程里去执行
  // 主线程继续处理其他任务或者先行结束，再通过Future获取计算结果

  // 代码：Runnable接口 Callab接口 Future接口和FutureTask实现类
  // 目的：异步多线程任务执行且有返回结果，三个特点：多线程/有返回/异步任务

  // 1.Thread(Runnable target, String name)

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 异步多线程
    FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
    Thread t1 = new Thread(futureTask, "t1");
    t1.start();
    System.out.println(futureTask.get());

  }
}

class MyThread implements Runnable {

  @Override
  public void run() {

  }
}

class MyThread2 implements Callable<String> {

  @Override
  public String call() throws Exception {
    System.out.println("---come in call()");
    return "hello Callable";
  }
}
/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： FutureAPIDemo.java
 * 模块说明：
 * 修改历史：
 * 2023年03月15日 - wanghuanyu - 创建。
 */
package com.example.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author wanghuanyu
 * @since 1.0
 */
public class FutureAPIDemo {

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, TimeoutException {
    FutureTask<String> futureTask = new FutureTask<String>(() -> {
      System.out.println(Thread.currentThread().getName() + "\t --- come in");
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "task over";
    });
    Thread t1 = new Thread(futureTask, "t1");
    t1.start();

    // Future缺点：出现阻塞
    // System.out.println(futureTask.get());// 不见不散，非要等到结果才会历来，不管你是否计算完成，容易程序阻塞
    System.out.println(Thread.currentThread().getName() + "\t ---忙其他任务了");
    // System.out.println(futureTask.get(3, TimeUnit.SECONDS));

    // isDone轮询，会耗费无谓的cpu资源，而且也不见得能及时的得到计算结果。
    // Future 对于结果的获取不是很友好，只能通过阻塞或者轮询的方式得到任务的结果。
    while (true) {
      if (futureTask.isDone()) {
        System.out.println(futureTask.get());
        break;
      } else {
        try {
          TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("正在处理中，不要再催了");
      }
    }
  }

}

/*
 * 1.get容易导致阻塞，一般建议放到程序后面，一旦调用不见不散，非要等到结果才会历来，不管你是否计算完成，容易程序阻塞。
 * 2.假如我不愿意等待很长时间，我希望过时不候，可以自动离开
 */
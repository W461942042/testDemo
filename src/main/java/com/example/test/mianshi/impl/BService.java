/**
 * 版权所有(C)，上海海鼎信息工程有限公司，2023，所有权利保留。
 * <p>
 * 项目名： testDemo* 文件名： BService.java
 * 模块说明：
 * 修改历史：
 * 2023年05月05日 - wanghuanyu - 创建。
 */
package com.example.test.mianshi.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public interface BService extends ExecutorService {

  CompletableFuture<Integer> get(List<Integer> ids);
}

package com.voole.cdcenter.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName: AsyncExecutorService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年1月11日 下午2:18:00
 * 
 */
public class AsyncExecutorService {
    private ThreadPoolExecutor executorService;
    private RejectedExecutionHandler rejectionHandler;
    private BlockingQueue<Runnable> blockingQueue;
    private int defaultCoreSize;
    private int defaultMaxSize;
    private long defaultKeepAliveTime;

    public RejectedExecutionHandler getRejectionHandler() {
        return this.rejectionHandler;
    }

    public void setRejectionHandler(RejectedExecutionHandler rejectionHandler) {
        this.rejectionHandler = rejectionHandler;
        this.executorService.setRejectedExecutionHandler(rejectionHandler);
    }

    public BlockingQueue<Runnable> getBlockingQueue() {
        return this.blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public ThreadPoolExecutor getExecutorService() {
        return this.executorService;
    }

    public void setExecutorService(ThreadPoolExecutor executorService) {
        this.executorService = executorService;
        this.defaultCoreSize = this.executorService.getCorePoolSize();
        this.defaultMaxSize = this.executorService.getMaximumPoolSize();
        this.defaultKeepAliveTime = this.executorService.getKeepAliveTime(TimeUnit.SECONDS);
    }

    public void execute(BaseAsyncRunner baseRunner) {
        this.executorService.execute(baseRunner);
    }

    public void resizePoolMaxSize(int maxSize) {
        this.executorService.setMaximumPoolSize(maxSize);
    }

    public void resizePoolCoreSize(int coreSize) {
        this.executorService.setMaximumPoolSize(coreSize);
    }

    public void resetPoolAliveTime(long aliveTime) {
        this.executorService.setKeepAliveTime(aliveTime, TimeUnit.SECONDS);
    }

    public void resetDefault() {
        this.executorService.setCorePoolSize(this.defaultCoreSize);
        this.executorService.setMaximumPoolSize(this.defaultMaxSize);
        this.executorService.setKeepAliveTime(this.defaultKeepAliveTime, TimeUnit.SECONDS);
    }

    @PostConstruct
    public void init() {
        // asyncExecutorService will be init !!!
    }

    @PreDestroy
    public void destroy() {
        // asyncExecutorService will be destroyed !!!
        this.executorService.shutdown();
    }

    public Integer getPoolMaxSize() {
        return this.executorService.getMaximumPoolSize();
    }
}

package com.voole.datasync.util;

/**
 * @ClassName: BaseAsyncRunner
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年1月11日 下午2:21:42
 * 
 */
public abstract class BaseAsyncRunner implements Runnable {
	public abstract void runrunrun();

	/*
	 * (非 Javadoc) <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.runrunrun();
	}
}

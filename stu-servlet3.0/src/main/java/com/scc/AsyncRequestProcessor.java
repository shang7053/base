/**   
 *
 * @Title: AsyncRequestProcessor.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月25日 下午3:53:34   
 */
package com.scc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;

/**
 *
 * @ClassName: AsyncRequestProcessor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月25日 下午3:53:34
 * 
 */
public class AsyncRequestProcessor implements Runnable {

	private AsyncContext asyncContext;
	private int milliseconds;

	public AsyncRequestProcessor() {

	}

	public AsyncRequestProcessor(AsyncContext asyncContext, int milliseconds) {
		this.asyncContext = asyncContext;
		this.milliseconds = milliseconds;
	}

	public void run() {
		System.out.println("Async Supported? " + this.asyncContext.getRequest().isAsyncSupported());
		this.longProcessing(this.milliseconds);
		try {
			PrintWriter out = this.asyncContext.getResponse().getWriter();
			out.write("Processing done for " + this.milliseconds + " milliseconds!!");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.asyncContext.complete();
	}

	private void longProcessing(int secs) {
		// wait for given time before finishing
		try {
			Thread.sleep(secs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**   
 *
 * @Title: AppAsyncListener.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月25日 下午3:54:49   
 */
package com.scc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

/**
 *
 * @ClassName: AppAsyncListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月25日 下午3:54:49
 * 
 */

@WebListener
public class AppAsyncListener implements AsyncListener {
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener complete");
	}

	public void onTimeout(AsyncEvent event) throws IOException {
		ServletResponse response = event.getAsyncContext().getResponse();
		PrintWriter out = response.getWriter();
		out.write("TimeOut Error in Processing");
		out.flush();
		out.close();

	}

	public void onError(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener error");
		ServletResponse response = event.getAsyncContext().getResponse();
		PrintWriter out = response.getWriter();
		out.write("error on processing");
		out.flush();
		out.close();
	}

	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("AppAsyncListener start");
	}

}

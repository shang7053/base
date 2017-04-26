/**   
 *
 * @Title: ApplicationListener.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月25日 下午3:53:59   
 */
package com.scc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @ClassName: ApplicationListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月25日 下午3:53:59
 * 
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 100, 50000L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5000));
		sce.getServletContext().setAttribute("executor", executor);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) sce.getServletContext().getAttribute("executor");
		executor.shutdown();
	}
}

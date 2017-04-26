/**   
 *
 * @Title: AsyncServlet.java 
 * @Package com.scc 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2017年4月25日 下午3:52:40   
 */
package com.scc;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @ClassName: AsyncServlet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2017年4月25日 下午3:52:40
 * 
 */
@WebServlet(asyncSupported = true, urlPatterns = "/asyncServlet")
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet Start::Name=" + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId());

        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        int secs = 10000;
        AsyncContext asyncCtx = request.startAsync();
        asyncCtx.addListener(new AppAsyncListener());
        asyncCtx.setTimeout(2000000);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) request.getServletContext().getAttribute("executor");
        executor.execute(new AsyncRequestProcessor(asyncCtx, secs));
        long endTime = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet End::Name=" + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId() + "::Time Taken=" + (endTime - startTime) + " ms.");
    }

}

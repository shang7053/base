package com.voole.cdcenter.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * 
 * @ClassName: UserValidateFilter
 * @Description: 用户验证过滤器，非登录用户禁止访问。do结尾的url
 * @author scc
 * @date 2014年11月4日 上午9:57:42
 *
 */
public class UserValidateFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("UserValidateFilter.destroy()");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String servletPath = request.getServletPath();
		// 不是以login.do结尾的要验证
		if (!servletPath.endsWith("login.do") && !servletPath.endsWith("login.jsp")) {
			UserVo user = (UserVo) request.getSession().getAttribute("user");
			if (null == user) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
			} else {
				arg2.doFilter(arg0, arg1);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("UserValidateFilter.init()");
	}

}

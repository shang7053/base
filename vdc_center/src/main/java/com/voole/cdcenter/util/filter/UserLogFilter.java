package com.voole.cdcenter.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.voole.cdcenter.entry.sytem.log.SystemLogEntry;
import com.voole.cdcenter.service.system.log.ISystemLogService;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * 
 * @ClassName: UserValidateFilter
 * @Description: 用户验证过滤器，非登录用户禁止访问。do结尾的url
 * @author scc
 * @date 2014年11月4日 上午9:57:42
 *
 */
public class UserLogFilter implements Filter {
	private static Boolean isStart = null;
	private static List<String> statisticationlist;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		if (isStart) {
			HttpServletRequest request = (HttpServletRequest) arg0;
			String servletPath = request.getServletPath();
			String[] paths = servletPath.split("/");
			String mappingname = paths[paths.length - 1];
			if (StringUtils.isNotBlank(mappingname) && !servletPath.endsWith("heartbeat.do")) {
				boolean ismatch = false;
				for (String string : statisticationlist) {
					if (mappingname.startsWith(string)) {
						ismatch = true;
						break;
					}
				}
				if (!ismatch) {
					SystemLogEntry sle = new SystemLogEntry();
					UserVo resUserEntry = (UserVo) request.getSession().getAttribute("user");
					if (null != resUserEntry) {
						sle.setCreate_time(new Date());
						sle.setUid(resUserEntry.getUid());
						sle.setUrl(servletPath);
						sle.setParam(JSON.toJSONString(request.getParameterMap()));
						BeanFactory beans = WebApplicationContextUtils
								.getWebApplicationContext(request.getSession().getServletContext());
						ISystemLogService sysytemLogService = (ISystemLogService) beans.getBean("ISystemLogService");
						sysytemLogService.addSystemLog(sle);
					}
				}
			}
			arg2.doFilter(arg0, arg1);
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		isStart = Boolean
				.valueOf(null == arg0.getInitParameter("isStart") || "".equals(arg0.getInitParameter("isStart"))
						? "false" : arg0.getInitParameter("isStart"));
		if (isStart) {
			if (!"".equals(arg0.getInitParameter("statisticationlist"))) {
				String[] temps = arg0.getInitParameter("statisticationlist").split(",");
				for (int i = 0; i < temps.length; i++) {
					temps[i] = temps[i].trim();
				}
				statisticationlist = Arrays.asList(temps);
			} else {
				statisticationlist = new ArrayList<String>();
			}
		}
	}
}

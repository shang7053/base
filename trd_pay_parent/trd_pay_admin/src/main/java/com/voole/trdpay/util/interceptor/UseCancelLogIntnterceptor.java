package com.voole.trdpay.util.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.voole.trdpay.entry.sytem.log.SystemLogEntry;
import com.voole.trdpay.service.system.log.ISystemLogService;
import com.voole.trdpay.vo.system.user.UserVo;

/**
 * @ClassName: UseCancelLogIntnterceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月12日 上午10:07:40
 * 
 */
@Repository
public class UseCancelLogIntnterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = Logger.getLogger(UseCancelLogIntnterceptor.class);
	@Reference
	private ISystemLogService systemLogService;

	/*
	 * (非 Javadoc) <p>Title: preHandle</p> <p>Description: </p>
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @param handler
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("user(" + request.getSession().getAttribute("user") + ") execute order cancel start");
		return true;
	}

	/*
	 * (非 Javadoc) <p>Title: postHandle</p> <p>Description: </p>
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @param handler
	 * 
	 * @param modelAndView
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		UserVo resUserEntry = (UserVo) request.getSession().getAttribute("user");
		SystemLogEntry sle = new SystemLogEntry();
		sle.setCreate_time(new Date());
		sle.setUid(resUserEntry.getUid());
		sle.setUrl(request.getServletPath());
		sle.setParam(JSON.toJSONString(request.getParameterMap()));
		this.systemLogService.addSystemLog(sle);
	}

	/*
	 * (非 Javadoc) <p>Title: afterCompletion</p> <p>Description: </p>
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @param handler
	 * 
	 * @param ex
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.debug("user(" + request.getSession().getAttribute("user") + ") execute order cancel end");
	}

}

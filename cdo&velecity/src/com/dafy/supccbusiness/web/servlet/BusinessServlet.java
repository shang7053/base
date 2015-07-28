package com.dafy.supccbusiness.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servlet.CDOServlet;
import com.dafy.supccbusiness.business.BusinessService;
/**
 * cdo请求统一入口
 * @author scc
 *
 */
public class BusinessServlet extends CDOServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public Return handleTrans(HttpServletRequest request,
			HttpServletResponse response, CDO cdoRequest, CDO cdoResponse) {
		Return ret = BusinessService.getInstance().handleTrans(cdoRequest,
				cdoResponse);

		return ret;
	}

	@Override
	public Return checkToDo(HttpServletRequest request, CDO cdoRequest) {
		return null;
	}

	@Override
	public void handleEvent(CDO cdoEvent) {
	}

	@Override
	protected boolean checkTrans(HttpServletRequest request, CDO cdoRequest) {
		return true;
	}

	@Override
	protected void onTransChecked(HttpServletRequest request, CDO cdoRequest,
			boolean bAllowed) {
	}

	@Override
	public void raiseEvent(CDO cdoEvent) {
	}
}

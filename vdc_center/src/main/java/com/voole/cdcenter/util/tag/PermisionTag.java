package com.voole.cdcenter.util.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.voole.cdcenter.vo.system.function.FunctionVo;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * @ClassName: PermisionTag
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月21日 下午12:39:40
 * 
 */
public class PermisionTag extends TagSupport {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月21日 下午12:56:39
	 */
	private static final long serialVersionUID = 5214294006268368946L;
	private String url;

	/*
	 * (非 Javadoc) <p>Title: doStartTag</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @throws JspException
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		if (StringUtils.isBlank(this.url)) {
			return SKIP_BODY;
		}
		boolean result = false;
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();// 通过成员变量获取HttpServletRequest对象
		UserVo loginuser = (UserVo) request.getSession().getAttribute("user");// 获取登录到系统的用户
		if (loginuser != null) {
			List<FunctionVo> allFunctions = loginuser.getAllFunctions();
			result = this.hasUrl(this.url, allFunctions);
		}
		return result ? EVAL_BODY_INCLUDE : SKIP_BODY;
	}

	/**
	 * @Title: hasUrl
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月21日 下午1:35:50
	 * @param url2
	 * @param allFunctions2
	 * @return
	 */
	private boolean hasUrl(String url2, List<FunctionVo> allFunctions2) {
		if (null == allFunctions2 || allFunctions2.size() == 0) {
			return false;
		}
		boolean hasurl = false;
		for (FunctionVo functionVo : allFunctions2) {
			if (functionVo.getFurl().equals(url2)) {
				hasurl = true;
				break;
			} else {
				hasurl = this.hasUrl(url2, functionVo.getChildFuncs());
				if (hasurl) {
					break;
				}
			}
		}
		return hasurl;
	}

	/**
	 * @return the url
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 下午1:26:18
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @author A18ccms a18ccms_gmail_com
	 * @date 2016年7月21日 下午1:26:18
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}

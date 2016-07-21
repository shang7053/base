package com.voole.cdcenter.controller.manager.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.service.system.function.IFunctionService;
import com.voole.cdcenter.service.system.rule.IRuleService;
import com.voole.cdcenter.service.system.user.IUserService;
import com.voole.cdcenter.util.ListUtils;
import com.voole.cdcenter.util.MD5;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.system.function.FunctionVo;
import com.voole.cdcenter.vo.system.rule.RuleVo;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * @ClassName: JumpController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月6日 下午3:19:43
 * 
 */
@Controller
@RequestMapping(("/loginController/"))
public class LoginController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	@Resource
	private IUserService userService;
	@Resource
	private IRuleService ruleService;
	@Resource
	private IFunctionService functionService;

	@RequestMapping("/login.do")
	public String login(String username, String passwordcode, HttpSession session, Model mpdel) {
		if (null != session.getAttribute("user")) {
			return "main";
		}
		if (StringUtils.isBlank(username) || StringUtils.isBlank(passwordcode)) {
			mpdel.addAttribute("msg", "登录失败！未输入用户名或密码！");
			return "login";
		}
		try {
			UserVo userqc = new UserVo();
			userqc.setUsername(username);
			UserVo loginUser = null;
			List<UserVo> loginUserList = this.userService.queryUser(userqc);
			if (null != loginUserList) {
				loginUser = loginUserList.get(0);
			}
			String pw = MD5.GetMD5Code(passwordcode);
			if (null != loginUser) {
				if (loginUser.getIs_on() == 0) {
					mpdel.addAttribute("msg", "登录失败！用户账户已冻结！");
					return "login";
				}
				if (pw.equals(loginUser.getPasswordcode())) {
					String error_pw_count = (String) session.getServletContext().getAttribute("error_pw_count");
					loginUser.setError_pw_count(
							StringUtils.isBlank(error_pw_count) ? 3 : Integer.valueOf(error_pw_count));
					loginUser.setLogin_time(new Date());
					// 重置登录次数
					this.userService.updateUser(loginUser);
					RuleVo rulequerycase = new RuleVo();
					rulequerycase.setUid(loginUser.getUid());
					List<RuleVo> rules = this.ruleService.queryUserRules(rulequerycase);
					loginUser.setRules(rules);
					FunctionVo functionquerycase = new FunctionVo();
					Integer[] rids = ListUtils.getTargetForIntegerArray(rules, "rid");
					functionquerycase.setRids(rids);
					functionquerycase.setIs_on(1);
					List<FunctionVo> functions = this.functionService.queryMenuFunction(functionquerycase);
					FunctionVo allfunctionquerycase = new FunctionVo();
					allfunctionquerycase.setRids(rids);
					allfunctionquerycase.setIs_on(1);
					List<FunctionVo> allFunctions = this.functionService.queryFunction(allfunctionquerycase);
					loginUser.setAllFunctions(allFunctions);
					loginUser.setFunctions(functions);

					session.setAttribute("user", loginUser);
					session.setAttribute("lockstatus", false);
					return "main";
				} else {
					if (loginUser.getError_pw_count() - 1 <= 0) {
						loginUser.setIs_on(0);
						loginUser.setError_pw_count(0);
						this.userService.updateUser(loginUser);
						mpdel.addAttribute("msg", "登录失败！错误尝试次数使用完毕，账户已冻结！请联系管理员重置密码！");
						return "login";
					}
					loginUser.setError_pw_count(loginUser.getError_pw_count() - 1);
					this.userService.updateUser(loginUser);
					session.setAttribute("user", loginUser);
					mpdel.addAttribute("msg", "登录失败！还有" + (loginUser.getError_pw_count() - 1) + "次尝试机会！");
					return "login";
				}
			} else {
				mpdel.addAttribute("msg", "登录失败！用户不存在！");
				return "login";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "login";
	}

	@RequestMapping("/unlock.do")
	@ResponseBody
	public AjaxRet unlock(String passwordcode, HttpSession session) {
		if (StringUtils.isBlank(passwordcode)) {
			return new AjaxRet(false, "密码不能为空！");
		}
		try {
			String pw = MD5.GetMD5Code(passwordcode);
			UserVo loginUser = (UserVo) session.getAttribute("user");
			if (null == loginUser) {
				return new AjaxRet(false, "session 已失效，请重新登录！");
			}
			if (loginUser.getIs_on() == 0) {
				return new AjaxRet(false, "解锁失败！用户账户已冻结！");
			}
			if (pw.equals(loginUser.getPasswordcode())) {
				String error_pw_count = (String) session.getServletContext().getAttribute("error_pw_count");
				loginUser.setError_pw_count(StringUtils.isBlank(error_pw_count) ? 3 : Integer.valueOf(error_pw_count));
				// 重置登录次数
				this.userService.updateUser(loginUser);
				session.setAttribute("user", loginUser);
				session.setAttribute("lockstatus", false);
				System.out.println(session.getAttribute("lockstatus"));
				return new AjaxRet(true, "解锁成功");
			} else {
				if (loginUser.getError_pw_count() - 1 <= 0) {
					loginUser.setIs_on(0);
					loginUser.setError_pw_count(0);
					this.userService.updateUser(loginUser);
					session.setAttribute("user", loginUser);
					return new AjaxRet(false, "解锁失败！错误尝试次数使用完毕，账户已冻结！请联系管理员重置密码！");
				}
				loginUser.setError_pw_count(loginUser.getError_pw_count() - 1);
				this.userService.updateUser(loginUser);
				session.setAttribute("user", loginUser);
				return new AjaxRet(false, "解锁失败，密码错误，还剩下" + (loginUser.getError_pw_count()) + "次尝试机会");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("loginout.do")
	public String loginout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}
}

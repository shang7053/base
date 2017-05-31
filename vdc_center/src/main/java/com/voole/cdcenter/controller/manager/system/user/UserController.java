package com.voole.cdcenter.controller.manager.system.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.entry.sytem.rule.UserRuleEntry;
import com.voole.cdcenter.entry.sytem.user.UserEntry;
import com.voole.cdcenter.service.system.rule.IRuleService;
import com.voole.cdcenter.service.system.settings.IUserRuleService;
import com.voole.cdcenter.service.system.user.IUserService;
import com.voole.cdcenter.util.ListUtils;
import com.voole.cdcenter.util.MD5;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.PageMessageVo;
import com.voole.cdcenter.vo.system.rule.RuleVo;
import com.voole.cdcenter.vo.system.rule.UserRuleVo;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午1:38:46
 * 
 */
@Controller
@RequestMapping("/userController/")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;
	@Resource
	private IUserRuleService userRuleService;
	@Resource
	private IRuleService ruleService;

	@RequestMapping("turnuser.do")
	public WebAsyncTask<ModelAndView> turnrule() {
		return new WebAsyncTask<>(() -> {
			return new ModelAndView("system/user/userlist");
		});
	}

	@RequestMapping("queryUser.do")
	@ResponseBody
	public WebAsyncTask<PageMessageVo> queryRule(PageMessageVo pmv, UserVo userquerycase) {
		return new WebAsyncTask<>(() -> {
			try {
				userquerycase.setPmv(pmv);
				List<UserVo> rules = this.userService.queryUser(userquerycase);
				pmv.setAaData(rules);
				Integer totalsize = this.userService.queryUserCount(userquerycase);
				pmv.setiTotalRecords(totalsize);
				pmv.setiTotalDisplayRecords(totalsize);
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return pmv;
		});
	}

	@RequestMapping("turnUserInfo.do")
	public WebAsyncTask<String> turnUserInfo(Integer uid, Model model) {
		return new WebAsyncTask<>(() -> {
			if (uid == null) {
				return "system/user/userinfo";
			}
			try {
				UserVo userqc = new UserVo();
				userqc.setUid(uid);
				List<UserVo> users = this.userService.queryUser(userqc);
				if (users != null && users.size() == 1) {
					model.addAttribute("userinfo", users.get(0));
				}
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return "system/user/userinfo";
		});
	}

	@RequestMapping("addUserRule.do")
	@ResponseBody
	public WebAsyncTask<AjaxRet> addUserRule(Integer uid, String rids) {
		return new WebAsyncTask<>(() -> {
			if (null == uid) {
				return new AjaxRet(false, "赋权失败");
			}
			try {
				UserRuleVo urv = new UserRuleVo();
				urv.setUid(uid);
				this.userRuleService.deleteUserRule(urv);
				String[] ids = rids.split(",");
				Set<Integer> idSet = new HashSet<>();
				for (String id : ids) {
					if (StringUtils.isNotBlank(id)) {
						idSet.add(Integer.valueOf(id));
					}
				}
				for (Integer id : idSet) {
					UserRuleEntry ure = new UserRuleEntry();
					ure.setCreate_time(new Date());
					ure.setRid(id);
					ure.setIs_on(1);
					ure.setUid(uid);
					this.userRuleService.insertUserRule(ure);
				}
				return new AjaxRet(true, "赋权成功");
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return new AjaxRet(false, "程序内部错误");
		});
	}

	@RequestMapping("queryUserRules.do")
	@ResponseBody
	public WebAsyncTask<List<RuleVo>> queryUserRules(UserRuleVo rulequerycase) {
		return new WebAsyncTask<>(() -> {
			if (null == rulequerycase) {
				return new ArrayList<>();
			}
			try {
				List<UserRuleVo> userrules = this.userRuleService.queryUserRule(rulequerycase);
				List<RuleVo> rules = null;
				if (null != userrules) {
					Integer[] rids = ListUtils.getTargetForIntegerArray(userrules, "rid");
					RuleVo ruleqc = new RuleVo();
					ruleqc.setRids(rids);
					rules = this.ruleService.queryRule(ruleqc);
				}
				if (null != rules) {
					return rules;
				}
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return new ArrayList<>();
		});
	}

	@RequestMapping("changeuser.do")
	@ResponseBody
	public WebAsyncTask<AjaxRet> changeuser(UserEntry ue) {
		return new WebAsyncTask<>(() -> {
			if (null == ue) {
				return new AjaxRet(false, "操作失败");
			}
			try {
				ue.setUpdate_time(new Date());
				if (StringUtils.isNotBlank(ue.getPasswordcode())) {
					ue.setPasswordcode(MD5.GetMD5Code(ue.getPasswordcode()));
				}
				if (this.userService.updateUser(ue)) {
					return new AjaxRet(true, "操作成功");
				}
				return new AjaxRet(false, "操作失败，数据已被他人操作！");
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return new AjaxRet(false, "程序内部错误");
		});

	}

	@RequestMapping("turnCreateUser.do")
	public WebAsyncTask<String> turnCreateUser() {
		return new WebAsyncTask<>(() -> {
			return "system/user/createuser";
		});
	}

	@RequestMapping("addUser.do")
	@ResponseBody
	public WebAsyncTask<AjaxRet> addUser(UserEntry ue, String rids, HttpSession session) {
		return new WebAsyncTask<>(() -> {
			if (null == ue) {
				return new AjaxRet(false, "创建失败");
			}
			try {
				String[] ids = rids.split(",");
				Set<Integer> idSet = new HashSet<>();
				for (String id : ids) {
					if (StringUtils.isNotBlank(id)) {
						idSet.add(Integer.valueOf(id));
					}
				}
				ue.setCreate_time(new Date());
				ue.setError_pw_count(3);
				String error_pw_count = (String) session.getServletContext().getAttribute("error_pw_count");
				ue.setError_pw_count(StringUtils.isBlank(error_pw_count) ? 3 : Integer.valueOf(error_pw_count));
				ue.setPasswordcode(MD5.GetMD5Code("123456"));
				Integer uid = this.userService.insertUser(ue);
				if (null != uid && uid != 0) {
					for (Integer id : idSet) {
						UserRuleEntry ure = new UserRuleEntry();
						ure.setCreate_time(new Date());
						ure.setUid(uid);
						ure.setIs_on(1);
						ure.setRid(id);
						this.userRuleService.insertUserRule(ure);
					}
					return new AjaxRet(true, "创建成功");
				}
			} catch (Exception e) {
				this.LOGGER.error(e.getMessage(), e);
			}
			return new AjaxRet(false, "程序内部错误");
		});
	}
}

package com.voole.cdcenter.controller.manager.system.rule;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.entry.sytem.function.RuleFunctionEntry;
import com.voole.cdcenter.entry.sytem.rule.RuleEntry;
import com.voole.cdcenter.service.system.function.IRuleFunctionService;
import com.voole.cdcenter.service.system.rule.IRuleService;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.PageMessageVo;
import com.voole.cdcenter.vo.system.function.RuleFunctionVo;
import com.voole.cdcenter.vo.system.rule.RuleVo;

/**
 * @ClassName: RuleController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月13日 上午10:03:08
 * 
 */
@RequestMapping("/ruleController/")
@Controller
public class RuleController extends BaseController {
    @Resource
    private IRuleService ruleService;
    @Resource
    private IRuleFunctionService ruleFunctionService;

    @RequestMapping("turnrule.do")
    public WebAsyncTask<ModelAndView> turnrule() {
        return new WebAsyncTask<>(() -> {
            return new ModelAndView("system/rule/rulelist");
        });
    }

    @RequestMapping("queryRule.do")
    @ResponseBody
    public WebAsyncTask<PageMessageVo> queryRule(PageMessageVo pmv, RuleVo rulequerycase) {
        return new WebAsyncTask<>(() -> {
            try {
                rulequerycase.setPmv(pmv);
                List<RuleVo> rules = this.ruleService.queryRule(rulequerycase);
                pmv.setAaData(rules);
                Integer totalsize = this.ruleService.queryUserRulesCount(rulequerycase);
                pmv.setiTotalRecords(totalsize);
                pmv.setiTotalDisplayRecords(totalsize);
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return pmv;
        });
    }

    @RequestMapping("addRuleFunction.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> addRuleFunction(Integer rid, String fids) {
        return new WebAsyncTask<>(() -> {
            if (null == rid) {
                return new AjaxRet(false, "赋权失败");
            }
            try {
                RuleFunctionVo rfv = new RuleFunctionVo();
                rfv.setRid(rid);
                this.ruleFunctionService.deleteRuleFunction(rfv);
                String[] ids = fids.split(",");
                Set<Integer> idSet = new HashSet<>();
                for (String id : ids) {
                    if (StringUtils.isNotBlank(id)) {
                        idSet.add(Integer.valueOf(id));
                    }
                }
                for (Integer id : idSet) {
                    RuleFunctionEntry rfe = new RuleFunctionEntry();
                    rfe.setCreate_time(new Date());
                    rfe.setFid(id);
                    rfe.setIs_on(1);
                    rfe.setRid(rid);
                    this.ruleFunctionService.insertRuleFunction(rfe);
                }
                return new AjaxRet(true, "赋权成功");
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("addRuleAndFunction.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> addRuleAndFunction(RuleEntry re, String fids) {
        return new WebAsyncTask<>(() -> {
            if (null == re) {
                return new AjaxRet(false, "创建失败");
            }
            try {
                String[] ids = fids.split(",");
                Set<Integer> idSet = new HashSet<>();
                for (String id : ids) {
                    if (StringUtils.isNotBlank(id)) {
                        idSet.add(Integer.valueOf(id));
                    }
                }
                re.setCreate_time(new Date());
                Integer rid = this.ruleService.insertRule(re);
                for (Integer id : idSet) {
                    RuleFunctionEntry rfe = new RuleFunctionEntry();
                    rfe.setCreate_time(new Date());
                    rfe.setFid(id);
                    rfe.setIs_on(1);
                    rfe.setRid(rid);
                    this.ruleFunctionService.insertRuleFunction(rfe);
                }
                return new AjaxRet(true, "创建成功");
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("freeze.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> freeze(RuleEntry re) {
        return new WebAsyncTask<>(() -> {
            if (null == re) {
                return new AjaxRet(false, "冻结失败");
            }
            try {
                re.setIs_on(0);
                re.setUpdate_time(new Date());
                if (this.ruleService.updateRule(re)) {
                    return new AjaxRet(true, "冻结成功");
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("turnRuleInfo.do")
    public WebAsyncTask<String> turnRuleInfo(Integer rid, Model model) {
        return new WebAsyncTask<>(() -> {
            try {
                RuleVo rulequerycase = new RuleVo();
                rulequerycase.setRid(rid);
                List<RuleVo> ruleVos = this.ruleService.queryUserRules(rulequerycase);
                if (null != ruleVos && ruleVos.size() == 1) {
                    model.addAttribute("rule", ruleVos.get(0));
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return "system/rule/ruleinfo";
        });
    }

    @RequestMapping("turnCreateRule.do")
    public WebAsyncTask<String> turnCreateRule() {
        return new WebAsyncTask<>(() -> {
            return "system/rule/createrule";
        });
    }
}

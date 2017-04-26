package com.voole.cdcenter.controller.manager.system.function;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.entry.sytem.function.FunctionEntry;
import com.voole.cdcenter.entry.sytem.function.RuleFunctionEntry;
import com.voole.cdcenter.service.system.function.IFunctionService;
import com.voole.cdcenter.service.system.function.IRuleFunctionService;
import com.voole.cdcenter.util.ListUtils;
import com.voole.cdcenter.vo.AjaxRet;
import com.voole.cdcenter.vo.system.function.FunctionVo;
import com.voole.cdcenter.vo.system.function.JstreeData;
import com.voole.cdcenter.vo.system.function.RuleFunctionVo;
import com.voole.cdcenter.vo.system.rule.RuleVo;
import com.voole.cdcenter.vo.system.user.UserVo;

/**
 * @ClassName: FunctionController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月13日 上午11:54:01
 * 
 */
@RequestMapping("/functionController/")
@Controller
public class FunctionController extends BaseController {
    @Resource
    private IFunctionService functionService;
    @Resource
    private IRuleFunctionService ruleFunctionService;

    @RequestMapping("turnFunction.do")
    public WebAsyncTask<ModelAndView> turnFunction() {
        return new WebAsyncTask<>(() -> {
            return new ModelAndView("system/function/functionlist");
        });
    }

    @RequestMapping("getFunctions.do")
    @ResponseBody
    public WebAsyncTask<List<JstreeData>> getFunctions(HttpSession session) {
        return new WebAsyncTask<>(() -> {
            try {
                List<JstreeData> data = new ArrayList<JstreeData>();
                UserVo loginUser = (UserVo) session.getAttribute("user");
                if (null == loginUser) {
                    return data;
                }
                List<RuleVo> rules = loginUser.getRules();
                FunctionVo functionquerycase = new FunctionVo();
                Integer[] rids = ListUtils.getTargetForIntegerArray(rules, "rid");
                functionquerycase.setRids(rids);
                List<FunctionVo> functionVos = this.functionService.queryFunction(functionquerycase);
                if (null != functionVos) {
                    for (FunctionVo functionVo : functionVos) {
                        data.add(new JstreeData(functionVo.getFid().toString(), functionVo.getPfid().toString(),
                                functionVo.getFname()));
                    }
                }
                data.add(new JstreeData("0", "#", "链接"));
                return data;
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new ArrayList<>();
        });
    }

    @RequestMapping("queryFunction.do")
    @ResponseBody
    public WebAsyncTask<FunctionVo> queryFunction(Integer fid) {
        return new WebAsyncTask<>(() -> {
            if (null == fid) {
                return new FunctionVo();
            }
            try {
                FunctionVo functionquerycase = new FunctionVo();
                functionquerycase.setFid(fid);
                List<FunctionVo> functionVos = this.functionService.queryFunction(functionquerycase);
                if (null != functionVos && functionVos.size() == 1) {
                    return functionVos.get(0);
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new FunctionVo();
        });
    }

    @RequestMapping("queryFunctionIds.do")
    @ResponseBody
    public WebAsyncTask<List<FunctionVo>> queryFunctionIds(Integer rid) {
        return new WebAsyncTask<>(() -> {
            if (null == rid) {
                return new ArrayList<>();
            }
            try {
                FunctionVo functionquerycase = new FunctionVo();
                functionquerycase.setRids(new Integer[] { rid });
                functionquerycase.setIs_on(1);
                List<FunctionVo> functionVos = this.functionService.queryFunction(functionquerycase);
                if (null != functionVos) {
                    return functionVos;
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new ArrayList<>();
        });
    }

    @RequestMapping("insertFunction.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> insertFunction(FunctionEntry entry, HttpSession session) {
        return new WebAsyncTask<>(() -> {
            if (null == entry) {
                return new AjaxRet(false, "添加失败");
            }
            try {
                entry.setCreate_time(new Date());
                Integer fid = this.functionService.insertFunction(entry);
                if (fid != null && fid != 0) {
                    UserVo loginUser = (UserVo) session.getAttribute("user");
                    if (null != loginUser) {
                        List<RuleVo> rules = loginUser.getRules();
                        for (RuleVo ruleVo : rules) {
                            RuleFunctionEntry rfe = new RuleFunctionEntry();
                            rfe.setCreate_time(new Date());
                            rfe.setFid(fid);
                            rfe.setIs_on(1);
                            rfe.setRid(ruleVo.getRid());
                            this.ruleFunctionService.insertRuleFunction(rfe);
                        }
                    }
                    return new AjaxRet(true, "添加成功");
                } else {
                    return new AjaxRet(false, "添加失败");
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("updateFunction.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> updateFunction(FunctionEntry entry) {
        return new WebAsyncTask<>(() -> {
            if (null == entry) {
                return new AjaxRet(false, "修改失败");
            }
            try {
                entry.setUpdate_time(new Date());
                if (this.functionService.updateFunction(entry)) {
                    return new AjaxRet(true, "修改成功");
                } else {
                    return new AjaxRet(false, "修改失败,数据已被他人操作");
                }
            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }

    @RequestMapping("deleteFunction.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> deleteFunction(FunctionEntry entry) {
        return new WebAsyncTask<>(() -> {
            if (null == entry) {
                return new AjaxRet(false, "删除失败");
            }
            try {
                RuleFunctionVo rfv = new RuleFunctionVo();
                rfv.setFid(entry.getFid());
                if (this.ruleFunctionService.deleteRuleFunction(rfv)) {
                    this.functionService.deleteFunction(entry);
                    return new AjaxRet(true, "删除成功");
                } else {
                    return new AjaxRet(false, "删除失败,数据已被他人操作");
                }

            } catch (Exception e) {
                this.LOGGER.error(e.getMessage(), e);
            }
            return new AjaxRet(false, "程序内部错误");
        });
    }
}

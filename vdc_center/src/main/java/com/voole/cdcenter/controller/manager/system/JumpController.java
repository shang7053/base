package com.voole.cdcenter.controller.manager.system;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import com.voole.cdcenter.controller.BaseController;
import com.voole.cdcenter.vo.AjaxRet;

/**
 * @ClassName: JumpController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月6日 下午3:36:38
 * 
 */
@Controller
@RequestMapping
public class JumpController extends BaseController {
    @RequestMapping("/extra_lock.do")
    public WebAsyncTask<ModelAndView> lock(HttpSession session) {
        return new WebAsyncTask<>(() -> {
            session.setAttribute("lockstatus", true);
            return new ModelAndView("extra_lock");
        });
    }

    @RequestMapping("/heartbeat.do")
    @ResponseBody
    public WebAsyncTask<AjaxRet> heartbeat() {
        return new WebAsyncTask<>(() -> {
            return new AjaxRet(true, "sucess");
        });
    }

    @RequestMapping("/tologin.do")
    public WebAsyncTask<ModelAndView> tologin(HttpSession session) {
        return new WebAsyncTask<>(() -> {
            session.setAttribute("lockstatus", false);
            return new ModelAndView("login");
        });
    }

}

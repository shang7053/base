/**   
* @Title: UserController.java 
* @Package sustainable.interactive.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午5:09:46   
*/
package sustainable.interactive.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sustainable.common.po.User;
import sustainable.common.vo.AjaxRetuen;
import sustainable.interactive.service.IUserService;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午5:09:46
 * 
 */
@RequestMapping("UserController")
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("toRegist.do")
    public ModelAndView toRegist(User user, Model model) {
        model.addAttribute("registUser", user);
        return new ModelAndView("regist");
    }

    @RequestMapping("login.do")
    public ModelAndView login(User user, Model model) {
        User loginUser = this.userService.login(user);
        if (null != loginUser) {
            model.addAttribute("message", "登录成功");
            model.addAttribute("registUser", loginUser);
            return new ModelAndView("main");
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping("regist.do")
    public ModelAndView regist(User user, Model model) {
        this.userService.regist(user);
        model.addAttribute("message", "正在注册，请稍等……");
        model.addAttribute("registUser", user);
        return new ModelAndView("tip");
    }

    @RequestMapping("toLogin.do")
    public ModelAndView toLogin(User user, Model model) {
        model.addAttribute("registUser", user);
        return new ModelAndView("login");
    }

    @RequestMapping("validateRegist.do")
    @ResponseBody
    public AjaxRetuen validateRegist(User user) {

        if (this.userService.validateRegist(user)) {
            return new AjaxRetuen("注册成功，即将返回登录页", "y");
        }
        return new AjaxRetuen("注册失败，请重新注册", "n");
    }
}

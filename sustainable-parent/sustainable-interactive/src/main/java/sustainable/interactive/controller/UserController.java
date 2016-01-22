/**   
* @Title: UserController.java 
* @Package sustainable.interactive.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午5:09:46   
*/
package sustainable.interactive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午5:09:46
 * 
 */
@RequestMapping("UserController")
public class UserController {
    @RequestMapping("toRegist")
    public ModelAndView toRegist() {
        return new ModelAndView("regist");
    }
}

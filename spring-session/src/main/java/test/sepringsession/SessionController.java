/**   
 *
 * @Title: SessionController.java 
 * @Package test.sepringsession 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年2月25日 上午11:49:53   
 */
package test.sepringsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @ClassName: SessionController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年2月25日 上午11:49:53
 * 
 */
@Controller
@RequestMapping("/SessionController")
public class SessionController {

    /**
     *
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年2月25日 上午11:49:53
     */
    public SessionController() {
        // TODO Auto-generated constructor stub
    }

    @RequestMapping("/test.do")
    public String test(Model model, HttpServletRequest request, String action, String msg) {
        HttpSession session = request.getSession();
        if ("set".equals(action)) {
            session.setAttribute("msg", msg);
        } else if ("get".equals(action)) {
            String message = (String) session.getAttribute("msg");
            model.addAttribute("msgFromRedis", message);
        }
        return "index2";
    }
}

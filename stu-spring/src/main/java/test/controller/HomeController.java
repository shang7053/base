/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月3日 上午10:18:15
*/
package test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spel.SpelTest;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author scc
 * @since 创建时间：2015年11月3日 上午10:18:15
 */
@Controller
public class HomeController {
    // @Value("#{testDao}")
    // private ITestDao iTestDao;
    @Resource
    private SpelTest spelTest;

    @RequestMapping("/home")
    public String test1(Model model) {
        model.addAttribute("testVo", new TestVO());
        return "index";
    }

    @RequestMapping("/add")
    public String test2(@Valid @ModelAttribute("testVo") TestVO testVo, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        } else {
            // this.iTestDao.add(testVo);
            return "index";
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("哈哈");
        list.add("哈哈");
        list.add("哈哈");
        list.add("哈哈");
        list.add("哈哈");
        return list;
    }

    @RequestMapping("/testspel")
    @ResponseBody
    public String testspel() {
        return this.spelTest.getflag();
    }
}

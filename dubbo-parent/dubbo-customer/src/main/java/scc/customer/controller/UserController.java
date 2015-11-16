package scc.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import scc.common.vo.User;
import scc.customer.service.IUserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping("addUser")
	public String addUser(User user){
		userService.addUser(user);
		return "index";
	}
}

package scc.cunsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.rpc.RpcContext;
import com.common.inter.IUserService;
import com.common.vo.User;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("testInsert.do")
	public String testInsert(User user){
		RpcContext.getContext().setAttachment("index", "1");//≤‚ ‘ThreadLocal
		userService.insert(user);
		userService.getUserById(1);
		userService.getUsers();
		return "redirect:getUsers.do";
	}
	@RequestMapping("getUserById.do")
	public String getUserById(Integer id,Model model){
		model.addAttribute("user", userService.getUserById(id));
		return "info";
	}
	@RequestMapping("getUsers.do")
	public String getUsers(Model model){
		model.addAttribute("users",userService.getUsers());
		return "index";
	}
}

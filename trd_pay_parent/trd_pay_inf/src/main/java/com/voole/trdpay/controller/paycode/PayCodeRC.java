package com.voole.trdpay.controller.paycode;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.service.system.user.IUserService;
import com.voole.trdpay.vo.system.user.UserVo;

/**
 * @ClassName: PayCodeRC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 上午10:13:09
 * 
 */
@RestController
@RequestMapping("paycode")
public class PayCodeRC {
	@Reference
	private IUserService userService;

	@RequestMapping("{id}")
	public List<UserVo> generatePayCode(@PathVariable("id") Integer id) {
		UserVo qc = new UserVo();
		qc.setUid(id);
		return this.userService.queryUser(qc);
	}
}

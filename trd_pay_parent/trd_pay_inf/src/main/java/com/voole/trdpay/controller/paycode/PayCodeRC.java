package com.voole.trdpay.controller.paycode;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.conf.SystemConf;
import com.voole.trdpay.controller.BaseRc;
import com.voole.trdpay.service.order.IOrderService;
import com.voole.trdpay.util.AssertUtils;
import com.voole.trdpay.util.rsa.RSASecurityUtil;
import com.voole.trdpay.vo.paycode.PayCodeRet;
import com.voole.trdpay.vo.paycode.PayCodeVo;

/**
 * @ClassName: PayCodeRC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月7日 上午10:13:09
 * 
 */
@RestController
@RequestMapping("paycode")
public class PayCodeRC extends BaseRc {
	@Resource
	private SystemConf systemConf;
	@Reference
	private IOrderService orderService;

	@GetMapping("/generatePayCode")
	public WebAsyncTask<PayCodeRet> generatePayCode(String data) {
		return new WebAsyncTask<>(() -> {
			this.LOGGER.debug("==========================================================");
			this.LOGGER.debug("start generatePayCode");
			PayCodeRet ret = new PayCodeRet();
			ret.setStatus(1);
			try {
				this.LOGGER.debug("data:" + data);
				if (StringUtils.isNotBlank(data)) {
					String realdata = data.replace(" ", "+");
					String jsondata = RSASecurityUtil.decrypt(realdata, this.systemConf.getPriKey());
					this.LOGGER.info("conver data to jsondata,jsondata=" + jsondata);
					PayCodeVo payCode = JSON.parse(jsondata, PayCodeVo.class);
					this.LOGGER.info("conver jsondata to PayCodeVo,PayCodeVo=" + payCode);
					AssertUtils.notNull(payCode, "无效的参数" + jsondata);
					AssertUtils.notNull(payCode.getHid(), "hid不能为空!");
					AssertUtils.notNull(payCode.getOrder_name(), "Order_name不能为空!");
					AssertUtils.notNull(payCode.getAmt(), "amt不能为空!");
					AssertUtils.notNull(payCode.getOemid(), "oemid不能为空!");
					AssertUtils.notNull(payCode.getOrder_type(), "Order_type不能为空!");
					AssertUtils.notNull(payCode.getUid(), "uid不能为空!");
					AssertUtils.notNull(payCode.getChcd(), "uid不能为空!");
					this.LOGGER.debug("conllect args for spd");
					ret = this.orderService.gengerQrCode(ret, payCode);
				}
			} catch (Exception e) {
				e.printStackTrace();
				ret.setDesc(e.getMessage());
				this.LOGGER.error(e);
				this.LOGGER.debug("error!end generatePayCode");
				this.LOGGER.debug("==========================================================");
				return ret;
			}
			this.LOGGER.debug("succsss,end generatePayCode!");
			this.LOGGER.debug("==========================================================");
			return ret;
		});
	}

}

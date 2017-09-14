package com.voole.trdpay.controller.manager.system.cache;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.voole.trdpay.controller.manager.BaseController;
import com.voole.trdpay.controller.manager.system.function.FunctionController;
import com.voole.trdpay.entry.sytem.cache.FlushDbEntry;
import com.voole.trdpay.service.system.cache.IFlushDbService;
import com.voole.trdpay.vo.AjaxRet;
import com.voole.trdpay.vo.PageMessageVo;
import com.voole.trdpay.vo.system.cache.FlushDbVo;

@RequestMapping("/flushdbController/")
@Controller
public class FlushDbController extends BaseController {
	private static final Logger LOGGER = Logger.getLogger(FunctionController.class);
	@Reference
	private IFlushDbService flushdbService;

	@RequestMapping("turnFlushDb.do")
	public ModelAndView turnFunction() {
		return new ModelAndView("system/cache/FlushDblist");
	}

	@RequestMapping("queryFlushDb.do")
	@ResponseBody
	public PageMessageVo queryFlushDb(PageMessageVo pmv, FlushDbVo FlushDbquerycase) {
		try {
			FlushDbquerycase.setPmv(pmv);
			List<FlushDbVo> rules = this.flushdbService.queryFlushDb(FlushDbquerycase);
			pmv.setAaData(rules);
			Integer totalsize = this.flushdbService.queryFlushDbCount(FlushDbquerycase);
			pmv.setiTotalRecords(Long.valueOf(totalsize));
			pmv.setiTotalDisplayRecords(Long.valueOf(totalsize));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return pmv;
	}

	@RequestMapping("changvalue.do")
	@ResponseBody
	public AjaxRet changvalue(FlushDbEntry mve) {
		if (null == mve) {
			return new AjaxRet(false, "操作失败");
		}
		try {
			mve.setUpdate_time(new Date());
			if (this.flushdbService.updateFlushDb(mve)) {
				return new AjaxRet(true, "操作成功");
			}
			return new AjaxRet(false, "操作失败，数据已被他人操作！");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("delFlushDb.do")
	@ResponseBody
	public AjaxRet delFlushDb(FlushDbEntry mve) {
		if (null == mve) {
			return new AjaxRet(false, "操作失败");
		}
		try {
			if (this.flushdbService.deleteFlushDb(mve)) {
				return new AjaxRet(true, "操作成功");
			}
			return new AjaxRet(false, "操作失败，数据已被他人操作！");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部错误");
	}

	@RequestMapping("turnFlushDbInfo.do")
	public String turnFlushDbInfo(FlushDbVo FlushDbquerycase, Model model) {
		if (null == FlushDbquerycase) {
			return "system/cache/FlushDbinfo";
		}
		try {
			List<FlushDbVo> FlushDbVos = this.flushdbService.queryFlushDb(FlushDbquerycase);
			if (null != FlushDbVos && FlushDbVos.size() == 1) {
				FlushDbVo msv = FlushDbVos.get(0);
				switch (msv.getInterval_unit()) {
				case 1:
					msv.setFtypename("年");
					break;
				case 2:
					msv.setFtypename("月");
					break;
				case 3:
					msv.setFtypename("周");
					break;
				case 5:
					msv.setFtypename("天");
					break;
				case 10:
					msv.setFtypename("小时");
					break;
				case 12:
					msv.setFtypename("分钟");
					break;
				case 13:
					msv.setFtypename("秒");
					break;
				default:

					break;
				}
				model.addAttribute("FlushDbinfo", FlushDbVos.get(0));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "system/cache/FlushDbinfo";
	}

	@RequestMapping("turnCreateFlushDb.do")
	public String turnCreateFlushDb() {
		return "system/cache/createFlushDb";
	}

	@RequestMapping("addFlushDb.do")
	@ResponseBody
	public AjaxRet addFlushDb(FlushDbEntry mve) {
		if (null == mve) {
			return new AjaxRet(false, "添加失败");
		}
		try {

			if (this.flushdbService.insertFlushDb(mve)) {
				return new AjaxRet(true, "操作成功");
			} else {
				return new AjaxRet(false, "操作失败");
			}
		} catch (Exception e) {
			FlushDbController.LOGGER.error(e.getMessage(), e);
		}
		return new AjaxRet(false, "程序内部异常");
	}

}

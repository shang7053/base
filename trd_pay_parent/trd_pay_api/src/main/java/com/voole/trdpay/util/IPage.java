package com.voole.trdpay.util;

import com.voole.trdpay.vo.PageMessageVo;

/**
 * @ClassName: IPage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月14日 下午2:08:34
 * 
 */
public interface IPage {
	void setPmv(PageMessageVo pmv);

	PageMessageVo getPmv();
}

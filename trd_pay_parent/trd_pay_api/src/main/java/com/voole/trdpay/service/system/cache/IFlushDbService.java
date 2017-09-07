package com.voole.trdpay.service.system.cache;

import java.util.List;

import com.voole.trdpay.entry.sytem.cache.FlushDbEntry;
import com.voole.trdpay.vo.system.cache.FlushDbVo;

/**
 * @ClassName: IFlushDbService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年6月13日 上午9:39:03
 * 
 */
public interface IFlushDbService {
	/**
	 * @Title: queryFlushDb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月8日 上午10:20:17
	 * @param FlushDbquerycase
	 * @return
	 */
	List<FlushDbVo> queryFlushDb(FlushDbVo FlushDbquerycase);

	/**
	 * @Title: updateFlushDbFunction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 上午11:59:42
	 * @param rfe
	 * @return
	 */
	Boolean updateFlushDb(FlushDbEntry re);

	/**
	 * @Title: insertFlushDb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午4:01:47
	 * @param re
	 * @return
	 */
	Boolean insertFlushDb(FlushDbEntry mve);

	Integer queryFlushDbCount(FlushDbVo flushDbquerycase);

	boolean deleteFlushDb(FlushDbEntry mve);
}

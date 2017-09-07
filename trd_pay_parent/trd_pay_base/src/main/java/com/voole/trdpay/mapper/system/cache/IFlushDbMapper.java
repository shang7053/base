package com.voole.trdpay.mapper.system.cache;

import java.util.List;

import com.voole.trdpay.entry.sytem.cache.FlushDbEntry;
import com.voole.trdpay.vo.system.cache.FlushDbVo;

/**
 * @ClassName: FlushDbMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:34
 * 
 */
public interface IFlushDbMapper {

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
	Integer updateFlushDb(FlushDbEntry re);

	/**
	 * @Title: insertFlushDb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月15日 下午4:01:47
	 * @param re
	 * @return
	 */
	Integer insertFlushDb(FlushDbEntry mve);

	/**
	 * @Title: queryMSyncStatisticsCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年3月30日 上午10:57:32
	 * @param mSyncStatisticsVo
	 * @return
	 */
	Integer queryFlushDbCount(FlushDbVo flushDbquerycase);

	/**
	 * @Title: deleteMSyncStatistics
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年3月30日 上午10:57:43
	 * @param mStatisticsEntry
	 * @return
	 */
	int deleteFlushDb(FlushDbEntry mve);
}

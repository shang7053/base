package com.voole.trdpay.service.system.cache;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.voole.trdpay.entry.sytem.cache.FlushDbEntry;
import com.voole.trdpay.mapper.system.cache.IFlushDbMapper;
import com.voole.trdpay.vo.system.cache.FlushDbVo;

@Service(timeout = 1200000)
public class FlushDbServiceImpl implements IFlushDbService {
	@Resource
	private IFlushDbMapper mapper;

	/*
	 * (非 Javadoc) <p>Title: queryFunction</p> <p>Description: </p>
	 * 
	 * @param functionquerycase
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.function.IFunctionService#queryFunction(com.voole.cdcenter.vo.system.function.
	 * FunctionVo)
	 */
	@Override
	public List<FlushDbVo> queryFlushDb(FlushDbVo FlushDbquerycase) {
		// TODO Auto-generated method stub
		return this.mapper.queryFlushDb(FlushDbquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: updateMSyncStatistics</p> <p>Description: </p>
	 * 
	 * @param mStatisticsEntry
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datasync.service.monitor.statistics.IMSyncStatisticsService#updateMSyncStatistics(com.voole.datasync.
	 * entry.monitor.statistics.MSyncStatisticsEntry)
	 */
	@Override
	public Boolean updateFlushDb(FlushDbEntry re) {
		// TODO Auto-generated method stub
		return this.mapper.updateFlushDb(re) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: insertMSyncStatistics</p> <p>Description: </p>
	 * 
	 * @param mStatisticsEntry
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datasync.service.monitor.statistics.IMSyncStatisticsService#insertMSyncStatistics(com.voole.datasync.
	 * entry.monitor.statistics.MSyncStatisticsEntry)
	 */
	@Override
	public Boolean insertFlushDb(FlushDbEntry mve) {
		// TODO Auto-generated method stub
		return this.mapper.insertFlushDb(mve) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: queryMSyncStatisticsCount</p> <p>Description: </p>
	 * 
	 * @param mSyncStatisticsVo
	 * 
	 * @return
	 * 
	 * @see com.voole.datasync.service.monitor.statistics.IMSyncStatisticsService#queryMSyncStatisticsCount(com.voole.
	 * datasync.vo.monitor.statistics.MSyncStatisticsVo)
	 */
	@Override
	public Integer queryFlushDbCount(FlushDbVo flushDbquerycase) {
		// TODO Auto-generated method stub
		return this.mapper.queryFlushDbCount(flushDbquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: deleteMSyncStatistics</p> <p>Description: </p>
	 * 
	 * @param mStatisticsEntry
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.datasync.service.monitor.statistics.IMSyncStatisticsService#deleteMSyncStatistics(com.voole.datasync.
	 * entry.monitor.statistics.MSyncStatisticsEntry)
	 */
	@Override
	public boolean deleteFlushDb(FlushDbEntry mve) {
		// TODO Auto-generated method stub
		return this.mapper.deleteFlushDb(mve) > 0;
	}

}

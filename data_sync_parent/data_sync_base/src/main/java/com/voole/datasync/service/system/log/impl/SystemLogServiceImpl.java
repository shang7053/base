package com.voole.datasync.service.system.log.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.voole.datasync.entry.sytem.log.SystemLogEntry;
import com.voole.datasync.mapper.system.log.ISystemLogMapper;
import com.voole.datasync.service.system.log.ISystemLogService;
import com.voole.datasync.vo.system.log.SysytemLogVo;

/**
 * @ClassName: ISysytemLogServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:38:28
 * 
 */
@Service(timeout = 1200000)
public class SystemLogServiceImpl implements ISystemLogService {
	@Resource
	private ISystemLogMapper systemLogMapper;

	/*
	 * (非 Javadoc) <p>Title: addSystemLog</p> <p>Description: </p>
	 * 
	 * @param sle
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.log.ISystemLogService#addSystemLog(com.voole.cdcenter.entry.sytem.log.
	 * SystemLogEntry)
	 */
	@Override
	public Boolean addSystemLog(SystemLogEntry sle) {
		return this.systemLogMapper.addSystemLog(sle) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: querySystemLogs</p> <p>Description: </p>
	 * 
	 * @param sysytemLogqc
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.log.ISystemLogService#querySystemLogs(com.voole.cdcenter.vo.system.log.
	 * SysytemLogVo)
	 */
	@Override
	public List<SysytemLogVo> querySystemLogs(SysytemLogVo sysytemLogqc) {
		return this.systemLogMapper.querySystemLogs(sysytemLogqc);
	}

	/*
	 * (非 Javadoc) <p>Title: querySystemLogsCount</p> <p>Description: </p>
	 * 
	 * @param sysytemLogqc
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.log.ISystemLogService#querySystemLogsCount(com.voole.cdcenter.vo.system.log.
	 * SysytemLogVo)
	 */
	@Override
	public Integer querySystemLogsCount(SysytemLogVo sysytemLogqc) {
		return this.systemLogMapper.querySystemLogsCount(sysytemLogqc);
	}

}

package com.voole.datasync.service.system.log;

import java.util.List;

import com.voole.datasync.entry.sytem.log.SystemLogEntry;
import com.voole.datasync.vo.system.log.SysytemLogVo;

/**
 * @ClassName: SysytemLogMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:32:02
 * 
 */
public interface ISystemLogService {

	/**
	 * @Title: addSystemLog
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月20日 下午5:40:29
	 * @param sle
	 */
	Boolean addSystemLog(SystemLogEntry sle);

	/**
	 * @Title: querySystemLogs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月21日 上午9:35:12
	 * @param sysytemLogqc
	 * @return
	 */
	List<SysytemLogVo> querySystemLogs(SysytemLogVo sysytemLogqc);

	/**
	 * @Title: querySystemLogsCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2016年7月21日 上午9:36:01
	 * @param sysytemLogqc
	 * @return
	 */
	Integer querySystemLogsCount(SysytemLogVo sysytemLogqc);

}

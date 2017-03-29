package com.voole.datasync.service.system.user.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.voole.datasync.entry.sytem.user.UserEntry;
import com.voole.datasync.mapper.system.user.IUserMapper;
import com.voole.datasync.service.system.user.IUserService;
import com.voole.datasync.vo.system.user.UserVo;

/**
 * @ClassName: IUserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:39:16
 * 
 */
@Service(timeout = 1200000)
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserMapper userMapper;

	/*
	 * (非 Javadoc) <p>Title: queryUser</p> <p>Description: </p>
	 * 
	 * @param username
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.user.IUserService#queryUser(java.lang.String)
	 */
	@Override
	public List<UserVo> queryUser(UserVo querycase) {
		return this.userMapper.queryUser(querycase);
	}

	/*
	 * (非 Javadoc) <p>Title: updateUser</p> <p>Description: </p>
	 * 
	 * @param loginUser
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.user.IUserService#updateUser(com.voole.cdcenter.entry.sytem.user.UserEntry)
	 */
	@Override
	public Boolean updateUser(UserEntry ue) {
		return this.userMapper.updateUser(ue) > 0;
	}

	/*
	 * (非 Javadoc) <p>Title: queryUserCount</p> <p>Description: </p>
	 * 
	 * @param userquerycase
	 * 
	 * @return
	 * 
	 * @see com.voole.cdcenter.service.system.user.IUserService#queryUserCount(com.voole.cdcenter.vo.system.user.UserVo)
	 */
	@Override
	public Integer queryUserCount(UserVo userquerycase) {
		return this.userMapper.queryUserCount(userquerycase);
	}

	/*
	 * (非 Javadoc) <p>Title: insertUser</p> <p>Description: </p>
	 * 
	 * @param ue
	 * 
	 * @return
	 * 
	 * @see
	 * com.voole.cdcenter.service.system.user.IUserService#insertUser(com.voole.cdcenter.entry.sytem.user.UserEntry)
	 */
	@Override
	public Integer insertUser(UserEntry ue) {
		return this.userMapper.insertUser(ue);
	}

}

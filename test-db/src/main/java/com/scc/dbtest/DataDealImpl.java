package com.scc.dbtest;

import java.util.Map;

import com.voole.datasync.sdk.IDataDeal;

/**
 * @ClassName: DataDealImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年4月7日 下午2:29:45
 * 
 */
public class DataDealImpl implements IDataDeal {

	/*
	 * (非 Javadoc) <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param data
	 * 
	 * @see com.voole.datasync.sdk.IDataDeal#insert(java.util.Map)
	 */
	@Override
	public void insert(Map<String, Object> data) {
		System.out.println(data);
	}

	/*
	 * (非 Javadoc) <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param data
	 * 
	 * @see com.voole.datasync.sdk.IDataDeal#delete(java.util.Map)
	 */
	@Override
	public void delete(Map<String, Object> data) {
		System.out.println(data);
	}

	/*
	 * (非 Javadoc) <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param data
	 * 
	 * @see com.voole.datasync.sdk.IDataDeal#update(java.util.Map)
	 */
	@Override
	public void update(Map<String, Object> data) {
		System.out.println(data);

	}

}

package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: DemoInfoRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月5日 下午4:39:26
 * 
 */
public interface DemoInfoRepository extends MongoRepository<DemoInfo, String> {
	DemoInfo findByName(String name);
}
